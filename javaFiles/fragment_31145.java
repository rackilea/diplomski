public class ApplicationTest extends WithApplication {
    @Before
    public void setup() {
        start(fakeApplication(inMemoryDatabase(), fakeGlobal()));
    }

    @Test
    public void shouldGetDealName() {
        List books = Book.find.all();
        Assert.assertEquals(books.size(), 1);
    }
}