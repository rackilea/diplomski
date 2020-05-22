@Test
public void test {
    Customer cust = new Customer();
    cust.setId(1);
    cust.setName("test");
    Address addr = new Address();
    addr.setStreet("test-st");
    IdCreator c = Mockito.spy(new IdCreator(cust,addr,null));
    doReturn(Mockito.mock(UniqueIdCreator.class)).when(c).makeIdCreator();
    getDao.getPresist.add(cust);
    getDao.getPresist.add(addr);
    c.createId();
}