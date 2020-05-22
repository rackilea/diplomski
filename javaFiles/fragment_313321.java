public class MyCompositeFormat implements DataFormat, CamelContextAware {

    public MyCompositeFormat(DataFormat... formats) {
        // store them to local variable
    }

    public CamelContext getCamelContext() {
        return camelContext;
    }

    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
      if (exchange.getIn().getHeader("SomeHeader",String.class).equals("whatever") {
        return someFormatYouStored.marshal(exchange,graph,stream);
      } else {
        return anotherFormat.marshal(exchange,graph,stream);
      }

    }

    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
      // similar approach to marshal
    }

}