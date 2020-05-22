@Test
@Transactional
public void test() {
   Pojo3 pojo3 = new Pojo3();
   pojo3.setF1("f1");
   pojo3.setF2("f2");
   pojo3.setF3("f3");      
   em.persist(pojo3);

   // **NOTE** the full package path to DTO object
   TypedQuery<Pojo2DTO> tq = em.createQuery(
         "SELECT NEW org.example.jpa.manyfields.Pojo2DTO(p3.id, p3.f1, p3.f2) "
      + " FROM Pojo3 p3 WHERE p3.id=:id", Pojo2DTO.class);
   tq.setParameter("id", pojo3.getId());

   Pojo2DTO pojo2dto = tq.getSingleResult(); 
   log.info("{}, {}, {}", pojo2dto.getId(), pojo2dto.getF1(), pojo2dto.getF2());

}