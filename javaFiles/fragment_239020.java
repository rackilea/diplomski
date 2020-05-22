@Bean
    @DependsOn("defaultWebflowConfigurer")
    public CasWebflowConfigurer acceptableUsagePolicyWebflowConfigurer() {
        return new MyAcceptableUsagePolicyWebflowConfigurer(...);
    }

    public class MyAcceptableUsagePolicyWebflowConfigurer extends 
                          AcceptableUsagePolicyWebflowConfigurer {}