@RunWith(Parameterized.class)
public class BazTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { new Foobar(),
                   new Barbar(), }  
           });
    }

    private Baz baz;

    public BazTest(Baz baz) {
        this.baz= baz;
    }

    @Test
    public void test() {
        // assert something about baz
    }
}