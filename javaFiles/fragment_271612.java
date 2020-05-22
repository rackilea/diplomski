public class MyMessageRoute extends RouteBuilder {
       public void configure() throws Exception {
           onException(Exception.class)
            .handled(true)
            .bean(PreDLQLogWriter.class) ;

           from(fromQueueName).id("RouteId")
            .transacted()
            //process message 

            ;
       }}

public class PreDLQLogWriter {
private static final org.slf4j.Logger LOG = 
                 org.slf4j.LoggerFactory.getLogger( PreDLQLogWriter.class ); 

int configuredDeliveryCount = maximumRedeliveries+1;
public void logMessageDetails(Exchange exchange) throws Exception {

  int actualDeliveryCount = exchange.getIn().getHeader("JMSXDeliveryCount") 
                   != null ? exchange.getIn().getHeader("JMSXDeliveryCount", 
                    Integer.class) : 0 ;
  if(actualDeliveryCount = configuredDeliveryCount) {
             LOG.info(" Pre-DLQ Log: Log the message with message id ");
   }}