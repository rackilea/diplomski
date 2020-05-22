EntityTransaction tx = entityManager.getTransaction();
try {
   tx.begin();
   try {
      for(SimpleTable simpleTable : simpleTables){
         simplaTable.setAddress(newAddress);
      }
   } finally {
      tx.commit();
   }
} catch (Exception e) {
   // handle exceptions from transaction methods
}