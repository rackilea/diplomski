findRoom(String name) {
        Query query = em.createQuery("SELECT a FROM Room a"
                + "WHERE a.roomname LIKE CONCAT('%',?1,'%')");
        query.setParameter(1, name);
        List rooms = query.getResultList();
        return rooms;
         }