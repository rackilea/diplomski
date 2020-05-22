import javapns.Push;

 public class PushTest {

       public static void main(String[] args) {

                Push.alert("Hello World!", "keystore.p12", "keystore_password", false, "Your token");


       }
 }