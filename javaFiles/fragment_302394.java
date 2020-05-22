Restaurant res = entityManager.find(Restaurant.class, restId,LockModeType.PESSIMISTIC_WRITE);

   if(res.getVote()>-1){
     res.setVote(res.getVote()+1); // assumed vote is int
   }
   entityManager.persist(res);
   entityManager.flush();