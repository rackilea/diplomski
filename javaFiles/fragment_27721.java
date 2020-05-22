import org.apache.camel.builder.RouteBuilder;


public class ReorganizingMessages extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:pointA")
                .resequence(header("grocery"))
                .to("log://org.apache.camel.howto?showAll=true&multiline=true")

                .aggregate().constant(true).completionTimeout(100L).
                aggregationStrategy(new StringAggregator())
                .to("file:target/pointB");
    }

}