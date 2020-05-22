@Test
public class MsgFlowIT extends TestNGCitrusTestDesigner {

    @Autowired
    private HttpClient todoClient;

    @CitrusTest(name = "SampleJavaTest.Send")
    public void sendAndReceive() {
        http()
            .client(todoClient)
            .send()
            .post("/api/values/Method1")
            .contentType("application/xml")
            .name("Method1")
            .messageType(MessageType.XML)
            .payload("<XmlMessage>msg1</XmlMessage>");

        http()
            .client(todoClient)
            .receive()
            .response(HttpStatus.OK)
            .header("X-SomeHeader", "expectedValue")
            .payload("<SomeExpectedXml>foo</SomeExpectedXml>");

        http()
            .client(todoClient)
            .send()
            .get("/api/values/Method2")
            .contentType("application/xml")
            .messageType(MessageType.XML)
            .name("Method2");

        http()
            .client(todoClient)
            .receive()
            .response(HttpStatus.FOUND)
            .header("X-SomeHeader", "expectedValue")
            .xpath("/some/expression", "expectedValue")
            .payload("<SomeExpectedXml>foo</SomeExpectedXml>");
    }
}