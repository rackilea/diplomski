public class StringTest {

 public String concat = "";
 private String txt() { return "Hello  "+concat; }

 protected void print() {
    System.out.println("Output: " + txt());
 }

 public static void main(String[] args) {
    StringTest tb = new StringTest();
    tb.concat = "World";
    tb.print();
  }
}