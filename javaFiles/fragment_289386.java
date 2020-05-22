@Bean
public IntegrationFlow filteringFlow() {
    return IntegrationFlows.from("someChannel")
            .filter("#jsonPath(...) matches ...")
            .channel("outChannel")
            .get();
}