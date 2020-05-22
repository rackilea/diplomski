@Namespace("/")
public class ProductAction extends ActionSupport {

  public String execute() {
    return SUCCESS;

  }

  @Action(value="product",
    results=@Result(location="/product-list.jsp")
  )
  public String search() {
    return SUCCESS;
  }
}