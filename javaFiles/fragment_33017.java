static ThreadLocal<List<String>> myResults = new ThreadLocal<>();

@BeforeClass
public static void setUpClass() {
    myResults.set(new ArrayList<String>());
}

// use it later in your code
@Test
public void myTestCase() {
     myResults.get().add("result");
}