package abc;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    public void configure() {
        long delay = 60 * 60 * 1000L;
        from("smb://otherUser@localhost/folder?password=secret&delay=" + delay)
        .to("file://home/otherUser/folder");
    }
}