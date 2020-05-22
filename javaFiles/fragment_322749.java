import ...

public class Application extends Controller {

  public static Result index() {
    List<StockItem> items = StockItem.find().findList();
    return ok(Json.toJson(items));
  }

}