public List<Object[]> getDetail(int id){
        StringBuilder bf = new StringBuilder();
         bf.append("SELECT ");
         bf.append("'ABC', ");
                ....
        return em.createQuery(bf.toString()) .getResultList(); -- getResultList returns List.
    }