@RunWith(Parameterized.class)
public class RepeatableTests {

@Parameter
public String name;

@Parameterized.Parameters(name="name")
public static List<String> data() {
    return Arrays.asList(new String[]{"Jon","Johny","Rob"});
}

@Test
public void runTest() {
    System.out.println("run --> "+ name);
}
}