@Configuration
public class FlowRegistryConfiguration extends AbstractFlowConfiguration {

    @Bean(name = "flowRegistry")
    public FlowDefinitionRegistry flowDefinitionRegistry() {

        FlowDefinitionRegistryBuilder builder = getFlowDefinitionRegistryBuilder(
            (FlowBuilderServices) getApplicationContext().getBean("flowBuilderServices"))
            .addFlowLocation(".../aFlow.xml");

        List<String> activeProfiles = Arrays.asList(getApplicationContext().getEnvironment().getActiveProfiles());

        if (activeProfiles.contains("test")) {
            builder = builder.addFlowLocation(".../bFlow.xml");
        }

        return builder.build();
    }
}