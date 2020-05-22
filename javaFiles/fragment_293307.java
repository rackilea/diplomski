public List<DkSystemtherapieMerkmaleEntity> getDkSystemtherapieMerkmaleEntities(int id) {
    Transaction tx = session.beginTransaction();
    String sql = "SELECT * FROM dk_systemtherapie_merkmale WHERE eintrag_id =:id";

    List<Object[]> resultList;
    resultList = session.createNativeQuery(sql)
            .addScalar("eintrag_id", IntegerType.INSTANCE)
            .addScalar("feldname", StringType.INSTANCE)
            .addScalar("feldwert", StringType.INSTANCE)
            .setParameter("id", id).getResultList();

    tx.commit();

    List<DkSystemtherapieMerkmaleEntity> merkmale = new ArrayList<>();
    for (Object[] o : resultList) {
        merkmale.add(new DkSystemtherapieMerkmaleEntity((Integer) o[0], (String) o[1], (String) o[2]));
    }

    return merkmale;
}