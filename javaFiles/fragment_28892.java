@Component
public class CamelComponent extends RouteBuilder{

    public static String fileName;

    @Override
    public void configure() throws Exception {      
        from("direct:firstRoute").convertBodyTo(String.class)
        .to("file:///D:/test/?fileName=${exchangeProperty.Id}"));
    }   
}