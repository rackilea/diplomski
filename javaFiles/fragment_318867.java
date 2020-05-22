Criteria crit1 = sessionC.createCriteria(OP_DOCTOR_VISIT.class, "OPDV1");
crit.createAlias("OPDV1.OP_VISIT", "OPDV2", JoinType.LEFT_OUTER_JOIN,
Restrictions.and(Restrictions.eq("OPDV2.FORM", "NEW"), Restrictions.ge("OPDV2.USER_DATETIME", fdate), Restrictions.le("OPDV2.USER_DATETIME", tdate)));
    crit.add(Restrictions.ge("OPDV1.USER_DATETIME", fdate));
    crit.add(Restrictions.le("OPDV1.USER_DATETIME", tdate));
    ProjectionList p1 = Projections.projectionList();
    p1.add(Projections.alias(Projections.count("OPDV1.OP_VISIT_ID"), "TOTAL"));
    p1.add(Projections.count("OPDV2.FORM"));
    p1.add(Projections.alias(Projections.sqlGroupProjection("date(this_.USER_DATETIME) as createdDate", "createdDate", new String[]{"createdDate"}, new Type[]{StandardBasicTypes.DATE}), "DAT"));
    crit.setProjection(p1);
    return crit.list();