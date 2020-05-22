public List<OriginLabel> findByCriteria(Link1 l1, Link2 l2, String att) {
    String sql = "FROM MyEntity e WHERE 1=1";
    HashMap parameters = new HashMap();
    if(l1 != null){
        sql += " AND e.link1 = :l1 ";
        parameters.put("l1", l1);
    }
    if(l2 != null){
        sql += " AND e.link2 = :l2 ";
        parameters.put("l2", l2);
    }
    if(att != null){
        sql += " AND e.attribute = :att ";
        parameters.put("att", l1);
    }
    Query query = getEntityManager().createQuery(sql);
    SQLUtility.setParameters(query, parameters);