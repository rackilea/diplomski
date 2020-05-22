public class MyClass {

    @JsonProperty("test")
    String test;

    String myPrivateTest;

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        MyClass c = new MyClass();
        c.test = "HELLO";
        c.myPrivateTest = "WORLD";
        System.out.println(objectMapper.writeValueAsString(c));
    }
}