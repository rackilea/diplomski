public class MyApp extends WebApplication{

    @Override
    public RequestCycle newRequestCycle(Request request, Response response){
        return new CustomRequestCycle(this, (WebRequest) request, response);
    }

}