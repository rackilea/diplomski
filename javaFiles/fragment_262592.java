@Bean
public IntegrationFlow producer1() {
      return IntegrationFlows.from(messageProducerSpec1) 
        .channel("input") 
        .get();
} 

@Bean
public IntegrationFlow producer2() {
      return IntegrationFlows.from(messageProducerSpec2) 
        .channel("input") 
        .get();
} 

...

@Bean
public IntegrationFlow mainFlow() {
      return IntegrationFlows.from("input") 
        .handle(handler) 
        .handle(aggregator) 
        .handle(endpoint) 
        .get();
}