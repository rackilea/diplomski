public List<ActivityCountByCategory> getCreatedUserDefinedActivityCountByDate(Date fromDate, Date toDate) {

        Query query;
        query = entityManager.createNativeQuery("SELECT" +
                " trunc(a.dato), fcode.TEXT, COUNT(1) FROM ACTIVITY a INNER JOIN ACTIVITY_CATEGORY act_cat ON a.ID=act_cat.ACTOR_ID INNER JOIN " +
                "user_defined_code fcode ON fcode.kode = act_cat.category where ... " + 
                "AND trunc(a.DATO) BETWEEN :fromDate AND :toDate GROUP BY trunc(a.dato), fcode.TEXT , fcode.lineNo ORDER BY fcode.lineNo ");
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);

        List<Object[]> resultList = query.getResultList();
        List<ActivityCountByCategory> list = new ArrayList<>();
        for (Object[] result : resultList) {
            list.add(new ActivityCountByCategory((String) result[1], (Number) result[2], (Date) result[0]));
        }
        return list;
    }