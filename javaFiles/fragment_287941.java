import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class AggregatorRoute extends RouteBuilder {
        @Override
        public void configure() throws Exception {
            from("direct:splitFiles")
                .split(body())
                .convertBodyTo(String.class)
                .to("direct:writeFiles")
            ;

            from("file:input")
                .convertBodyTo(String.class)
                .log("current message:: ${body}")
                .aggregate(new AggregationStrategy() {
                    @Override
                    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                        String newMessage=newExchange.getIn().getBody(String.class);
                        List<String> messageList=null;
                        if(oldExchange == null) {
                            messageList=new ArrayList<String>();
                        }
                        if(oldExchange != null && newExchange!=null) {
                            messageList=oldExchange.getIn().getBody(List.class);
                        }
                        messageList.add(newMessage);
                        newExchange.getOut().setBody(messageList);
                        return newExchange;
                    }

                })
                .constant(true)
                .completionSize(3)
                .log("current message:: ${body}")
                .to("direct:splitFiles")
           ;

        }
    }