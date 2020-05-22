public class MyProcessor implements Processor{

@Override
public void process(Exchange exchange) throws Exception {
    ProducerTemplate producerTemplate = exchange.getContext().createProducerTemplate();

    ModelObject[] arrModelObjects = (ModelObject[]) exchange.getIn().getBody();

    for (ModelObject ob : arrModelObjects) {
        producerTemplate.sendBody("direct:someEndpoint", ob);
    }
}