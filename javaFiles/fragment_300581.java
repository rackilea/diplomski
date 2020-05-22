public class DefaultRouteBuilder extends RouteBuilder {

@Override
public void configure() throws Exception {

    from("servlet:hello?matchOnUriPrefix=true")
    .routeId("HTTP Bridging Route")
    .log("Request: ${in.header."+ Exchange.HTTP_METHOD +"} to ${in.header."+ Exchange.HTTP_URI +"}")
    .to("https://another.service.com?bridgeEndpoint=true");
}

}