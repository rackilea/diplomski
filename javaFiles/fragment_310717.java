@Endpoint
public class MyEndPoint{

    @PayloadRoot(namespace = "myns", localPart = "rootelement")
    @ResponsePayload
    public MyResponse myMethod(@RequestPayload MyRequest request)