from("direct:getContact")
    .process(new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {
            CamelContext context = exchange.getContext();
            ProducerTemplate producerTemplate = context.createProducerTemplate();

            // Asynchronous call to internal route
            Future<Contact> contact = 
                producerTemplate.asyncRequestBody("direct:invokeSomeRestApi", null, Contact.class);  

            // Do rest of the work
            exchange.getOut().setBody(contact.get());
        }
    });

// Unmarshalling REST response
JacksonDataFormat jacksonDataFormat = new JacksonDataFormat();
jacksonDataFormat.setUnmarshalType(Contact.class);

// Internal route definition
from("direct:invokeSomeRestApi")
    .to("http://localhost:8080/api/contact/2345")
    .unmarshal(jacksonDataFormat);