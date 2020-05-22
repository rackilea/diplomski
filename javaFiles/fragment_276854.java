public List<Account> getAccountFromStoreProcedure(EntityManager em, String routeCode, String round) 
{    
      StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("getAccountFunction");
    // set parameters
      storedProcedure.registerStoredProcedureParameter("in_route", String.class, ParameterMode.IN);
      storedProcedure.registerStoredProcedureParameter("in_round", String.class, ParameterMode.IN);
      storedProcedure.setParameter( "in_route",routeCode);
      storedProcedure.setParameter( "in_round",round);
      storedProcedure.executeUpdate();

      List<Object> objectList = storedProcedure.getResultList();

      for (int i = 0; i< objectList.size(); i++) {
          Account currAccount = new Account ((Object[]) objectList.get(i));
          tmpList.add(currAccount);
          System.out.println("currAccount : " + currAccount.toString()); }
    }