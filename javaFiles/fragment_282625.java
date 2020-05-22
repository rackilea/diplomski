@Bean
public IntegrationFlow() {
    return IntegrationFlows.from(INetSuiteCurrencyPullService.class)
         .handle("bean1", "method1")
         .handle("bean2", "method2")
         .get();
}