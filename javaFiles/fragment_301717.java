public class MyclassTest {
    private MyClass myClass;

    @Before
    public void setup() {
        this.myClass = new MyClass();
    }

    @Test
    public void testGetListValServiceWhenFieldIsNull() {
        assertNotNull(this.myClass.getListValService());
    }

    @Test
    public void testGetListValServiceWhenFieldIsNotNull() {
        final ListValServiceRemote  lvsr = new ListValServiceRemote();
        ReflectionTestUtils.setField(this.myClass, "listValService", lvsr);
        assertSame(lvsr, this.myClass.getListValService());
    }
}