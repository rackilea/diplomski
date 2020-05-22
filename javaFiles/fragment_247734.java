public static List<YourEntity> getFromTable(String name,String surname) {
        EntityManager em = PersistenceManager.instance().createEntityManager();

        try {
            String sql = " select * from table where 1=1 ";
            if(name!=null && !name.trim().isEmpty()){
                sql +=" and name = :name";
            }
            if(surname!=null && !surname.trim().isEmpty()){
                sql +=" and surname = :surname";
            }

            Query q = em.createNativeQuery(sql);
             if(name!=null && !name.trim().isEmpty()){
               q.setParameter("name", name);
            }
            if(surname!=null && !surname.trim().isEmpty()){
               q.setParameter("surname", surname);
            }

            List<YourEntity> l = q.getResultList();
            return l;
        } finally {
            em.close();
        }
    }