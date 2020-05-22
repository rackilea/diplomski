public class MyProcessorimplements Processor {

     @Override
     public void process(Exchange exchange) throws Exception {
         exchange.getIn().setHeader("headerName", yourOrderObject);
     }
}