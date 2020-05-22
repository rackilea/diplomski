public void deleteB(B b) {
   Long count = entityManager.createQuery("select count(a) from A a where a.b.id = :b")
                             .setParameter("b", b.getId())
                             .getSingleResult):
   if (count == 0L) {
       // delete B
   } else {
       // make B inactive
   }
}