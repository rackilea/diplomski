from("direct:getContact")
    .process(new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {
            CamelContext context = exchange.getContext();
            ProducerTemplate producerTemplate = context.createProducerTemplate();
            //Call another route not the rest endpoint
            Future<Contact> contact = producerTemplate.requestBodyAndHeaders( 
                "direct:RetrieveContactRoute", 
                 null, headers, Contact.class); 

             logger.info("Contact is: " + new ObjectMapper().writeValueAsString(contact.get())); 

             //Set the In Body not the Out Body 
             exchange.getIn().setBody(contact.get());
    });