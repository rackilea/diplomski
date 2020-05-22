try {
    emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = emFactory.createEntityManager();

    em.getTransaction().begin(); //added

    Query qry = em.createQuery("select t from TestCon t");
    System.out.println(qry);

    //need to use getResultList() if table has > 1 row
    List<TestCon> tcon = (List<TestCon>) qry.getResultList();

    for(Testcon rslt:tcon){ 
         rslt = tcon.getB();
         if (rslt == null || rslt.equals("")){
             rslt = "Could not get result";
         }
         System.out.println(rslt); //new ShowMsg(rslt);
    }

    entityManager.getTransaction().commit(); //added
    entityManager.close(); //added
} catch (Exception ex) {
 System.out.println(ex); //new ShowMsg("Exception occured");
}