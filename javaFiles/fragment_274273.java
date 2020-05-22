public class Test {

    public Test() {
        super();
    }

    public String getTestMessageA() {
        return "HelloWorld..!";
    }

    public String getTestMessageB() {
        return new StringBuffer("Hello").append("World..!").toString();
    }
}