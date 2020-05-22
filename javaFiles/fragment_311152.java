@RunWith(Parameterized.class)
 public class RepeatableTests {

 private String name;

 public RepeatableTests(String name) {
    this.name = name;
 }

 @Parameterized.Parameters
 public static List<String> data() {
    return Arrays.asList(new String[]{"Jon","Johny","Rob"});
 }

 @Test
 public void runTest() {
    System.out.println("run --> "+ name);
 }
}