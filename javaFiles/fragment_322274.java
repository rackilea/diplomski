Criteria criteria = session.createCriteria(CnTermsGroup.class, "cnTermsGroup")
        .createAlias("cnTermsGroup.cnTermsCounteds", "cnTermsCounted")
        .createAlias("cnTermsCounted.cnTermsRuns", "cnTermsRuns")
        .setProjection(Projections.projectionList().add(Projections.alias(Projections.property("cnTermsRuns.id"), "cnTermsRunId")).add(Projections.alias(Projections.property("cnTermsRuns.cnTermsCounted"), "cnTermsCounted")))
        .setResultTransformer(Transformers.aliasToBean(CnTermsRun.class));
List<CnTermsRun> subEntities = criteria.list();