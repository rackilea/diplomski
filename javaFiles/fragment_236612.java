@ManagedBean(name = "myBean")
@SessionScoped //for example
public class MyBean {
   private String value;

   private String result;

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public String getResult() {
      return result;
   }

   public void invokeService(ActionEvent actionEvent) {
      this.result = "Hello, " + value + "!";
   }
}