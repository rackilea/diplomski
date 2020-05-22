public class SomeDaoTest {

    @Test
    public void canGetAllSkeletons() {
       EntityManagerFactory entityManagerFactory = Mockito.mock(EntityManagerFactory.class);

       Mockito.when(entityManagerFactory.create()).thenReturn(entityManager);

       SomeDao sut = new SomeDao(entityManagerFactory.class);

       // now SomeDao will use your mocked EntityManager so you can set expectations
       // on createQuery etc to drive your test scenarios
       // ...
    }
}