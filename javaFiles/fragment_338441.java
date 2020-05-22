Query query = entityManager
                .createNativeQuery("SELECT anno_id, a.user_id FROM Annotation AS a"
                        + " LEFT JOIN group_membership g ON g.user_id = ?"
                        + " WHERE a.user_id = ?"
                        + " AND (a.access_control='PUBLIC'"
                        + " OR (a.access_control='GROUP' AND a.group_id = g.group_id)"
                        + " OR (a.access_control='PRIVATE' AND g.user_id = a.user_id))"
                        + " GROUP BY a.anno_id");
        query.setParameter(1, new Long(1));
        query.setParameter(2, new Long(1));
        List<Object[]> list = query.getResultList();
        return list;