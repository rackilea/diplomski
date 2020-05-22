public class MyController extends Controller {
    private MyService service = new MyService();

    @Override
    public Navigation run() throws Exception {
        Key myKey = asKey("key");
        MyObject myObject = service.getObject(myKey);
        requestScope("myObject", myObject);
        return forward("edit.jsp");
    }
}