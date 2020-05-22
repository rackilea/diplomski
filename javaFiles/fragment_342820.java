@RunWith(Parameterized.class)
public class FibonacciTest {

@Parameters
public static Iterable<? extends Object> urls() {
    return Arrays.asList("localhost:80/my/first/url", "localhost:80/my/second/url" );
}

@Parameter 
public /* NOT private */ String url;

@Test
public void checkErrorStatusForURLs() {
        given().when().get(url)
               .then().statusCode(CoreMatchers.not(500));
 ...
}
}