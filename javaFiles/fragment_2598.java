@RunWith(Parameterized.class)
public class Test {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "https://myHost/whrong.fileextension" }, 
                 { "https://myHost/not.existsing"}  
           });
    }

    private String url;


    public Test(String url) {
        this.url = url;
    }

    @Test(expected = IOException.class)
    public void test() throws IOException {
       MyClass myClass = new MyClass(url);
    }
}