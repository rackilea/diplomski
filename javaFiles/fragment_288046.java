@Provider
@Conumes("application/custom")
public class MyReader implements MessageBodyReader<String> {
}

Response res = client.target("test")
        .register(MyReader.class)
        .request("application/custom")
        .get();