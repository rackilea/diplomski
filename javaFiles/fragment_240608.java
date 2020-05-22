hibernateTemplate.execute(session -> {
     CriteriaBuilder builder = session.getCriteriaBuilder();
     CriteriaQuery<HumanMainInfo> query = builder.createQuery(HumanMainInfo.class);
     Root<SysUserMainInfo> sysUserRoot = query.from(SysUserMainInfo.class);
     Join<SysUserMainInfo, HumanMainInfo> humanJoin = sysUserRoot.join("human", JoinType.INNER);
     Predicate idCondition = builder.equal(sysUserRoot.get("id"), userId); 
     query.where(idCondition).select(humanJoin);
     return session.createQuery(query).uniqueResult();
});