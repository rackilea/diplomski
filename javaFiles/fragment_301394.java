public class SomeServiceTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    /** Just makes sure no exception is thrown */
    @Test
    public void sortByFieldX() {
        List<MyClass> list = null;
        SomeService service = new SomeService();
        service.sortByFieldX(list);
    }
}