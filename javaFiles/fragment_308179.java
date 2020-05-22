@Test
public void test {
    Customer cust = new Customer();
    cust.setId(1);
    cust.setName("test");
    Address addr = new Address();
    addr.setStreet("test-st");
    IdCreator c = Mockito.spy(new IdCreator(cust,addr,null) {
      @Override protected UniqueIdCreator makeIdCreator() {
        return Mockito.mock(UniqueIdCreator.class);
      }
    });
    getDao.getPresist.add(cust);
    getDao.getPresist.add(addr);
    c.createId();
}