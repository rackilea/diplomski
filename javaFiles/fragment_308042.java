public class FooDao {
    @Value("...")
    private int yourConfiguredValue;

    public getFoo() {
        Foo foo = sessionFactory.getCurrentSession().get(...);
        foo.setYourValue(yourConfiguredValue);
        return foo;
    }
}