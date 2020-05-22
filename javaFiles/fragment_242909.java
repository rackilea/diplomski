//Route Definition - myBean::saySomething() always returns String "Hello World"
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:hello?period={{timer.period}}").routeId("hello_route")
            .transform().method("myBean", "saySomething")
            .to("log:foo")
                .setHeader("test_header",constant("test"))
            .to("log:bar");
    }

}