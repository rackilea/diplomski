public class Bbb extends ActionSupport {

  private String key;
  //setter

  private List<String> value = new ArrayList<>();
  //getter

  public String ccc(){
    value.add("Something");
    return SUCCESS;
  }
}