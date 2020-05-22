public class Test {
    public String getTestMessageA() {
        return "Hello" + "World..!";
    }

    public String getTestMessageB() {
        return new StringBuffer("Hello").append("World..!").toString();
    }
}