protected ServiceRegistry getServiceRegistry() {
        ProcessEngineConfigurationImpl config = Context.getProcessEngineConfiguration();
        if (config != null) {
            // Fetch the registry that is injected in the activiti spring-configuration
            ServiceRegistry registry = (ServiceRegistry) config.getBeans().get(ActivitiConstants.SERVICE_REGISTRY_BEAN_KEY);

            if (registry == null) {
                throw new RuntimeException("Service-registry not present in ProcessEngineConfiguration beans, expected ServiceRegistry with key" + ActivitiConstants.SERVICE_REGISTRY_BEAN_KEY);
            }

            return registry;
        }
        throw new IllegalStateException("No ProcessEngineCOnfiguration found in active context");
    }