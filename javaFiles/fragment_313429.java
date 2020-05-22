@Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        //predicates from filters for main project
        Predicate mainPredicate = super.toPredicate(root, cq, cb);
        //exclude subprojects predicate
        Predicate ignoreSubPred = cb.and(cb.notEqual(root.get(Project_.projectStatus), ProjectStateEnum.SUB_PROJECT));

        // Subquery to get subprojects
        Subquery<Project> sq = cq.subquery(Project.class);
        Root<Project> subRoot = sq.from(Project.class);
        // Get same filters for the sub projects that are applied ot main project (same entity type)
        Predicate subPredicate = super.toPredicate(subRoot, cq, cb);
        // Include Subprojects
        Predicate includeSubPred = cb.and(cb.isNotNull(subRoot.get(Project_.subParent)));
        // Subquery selects parent for subprojects where conditions met
        sq.select(subRoot.get(Project_.subParent))
        .where(cb.and(cb.equal(root, subRoot.get(Project_.subParent)), includeSubPred, subPredicate));

        // return main project meets criteria or main project is in sub query of subprojects where condition met
        return cb.or(cb.and(mainPredicate, ignoreSubPred), cb.in(root).value(sq));
    }