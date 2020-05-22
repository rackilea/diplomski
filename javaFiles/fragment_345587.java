@Endpoint
public class FilteredEndpoint {
    @ResponsePayload
    @PayloadRoot(localPart = "HolidayRequest", namespace = "http://mycompany.com/hr/schemas")
    public void doRespose(@RequestPayload Element request) {
        System.out.println(Context.ip.get());
    }
}