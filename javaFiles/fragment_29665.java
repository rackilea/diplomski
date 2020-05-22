A saveAndAddB(A a, String desc){
   EntityManager em = factory.createEntityManager();
   em.getTransaction().begin();
   mngedA = em.merge(a);
   B b = new B();
   b.setDesc(desc);
   b.setA(mngedA);
   mngedA.getBList().add(b);;
   em.persist(b);
   em.getTransaction.commit();
   em.close();
   return mngedA;
}