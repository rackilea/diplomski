public class MyDAOTest {
@Test
public void shouldSelect() {
    DBI dbi = new DBI("jdbc:(something)", "something", "something");
    dbi.registerContainerFactory(new OptionalContainerFactory());
    ...
}