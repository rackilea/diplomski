public class MyTest {
    [...]

    private @Inject EntityManager entityManager

    @Test @InSequence(0)
    public void shouldHaveFoo() {
        Foo foo = entityManager.find(Foo.class, Long.valueOf(1));
        assertNotNull(foo);
    }

    @Test @InSequence(1)
    public void shouldHaveBar() {
        Bar bar = entityManager.find(Bar.class, Long.valueOf(99));
        assertNotNull(bar);
    }
}