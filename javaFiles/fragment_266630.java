public class MyTestClass {

    @PersistenceContext
    private EntityManager em;

    @Test
      public void testDefaultFieldsArePopulated() {

        Customer bhau = new Customer();
        bhau.setName("Bhau & Sons Pvt. Ltd.");
        bhau.setDomain(RandomStringUtils.randomAlphanumeric(8));

        bhau = customerRepository.saveAndFlush(bhau);
        em.clear(); //db lookup will now happen

        Customer badaBhau = customerRepository.findById(bhau.getId());
        assertThat(badaBhau.getTds().doubleValue()).isEqualTo(0.10);
        assertThat(badaBhau.getInvoicePrefix()).isEqualTo("INV");
        assertThat(badaBhau.getCurrency()).isEqualTo("INR");
      }
}