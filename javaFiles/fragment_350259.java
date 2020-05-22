if (!barCriteria.isEmpty()) {
    Disjunction or = Restrictions.disjunction();
    for (Criterion criteria : barCriteria) {
        or.add(criteria);
    }
    query.add(or);
}