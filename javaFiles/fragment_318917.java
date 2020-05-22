spec.subFlowMapping("connection101", new IntegrationFlow() {

      @Override
      void configure(IntegrationFlowDefinition<?> flow) {
           flow.handle(...);
      }

})