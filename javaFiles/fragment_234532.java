List<Map<Long, Long>> test = new ArrayList<Map<Long, Long>>();
try {
    String HQL_QUERY = "select new map(hp.col1, hp.col2) from HP hp where hp.col1 in (:id)";
    test = getSession().createQuery(HQL_QUERY).setParameter("id", id).list();
}catch(Exception e){

}