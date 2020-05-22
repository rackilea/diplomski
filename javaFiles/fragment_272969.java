new GenericTransformer<Message<JAXBElement<SomeStruct>>, SpecificEvent>() {
   @Override
   public SpecificEvent transform(Message<JAXBElement<SomeStruct>> message) {
        return new SpecificEvent(
                       message.getPayload().getValue(), 
                       Source.valueOf(message.getHeaders().get("source", String.class))
                       );
   }
}