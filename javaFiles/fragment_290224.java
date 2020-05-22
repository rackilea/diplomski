/**
     * Add an object which will be registered as an {@link IntegrationFlow} dependant bean in the
     * application context. Usually it is some support component, which needs an application context.
     * For example dynamically created connection factories or header mappers for AMQP, JMS, TCP etc.
     * @param bean an additional arbitrary bean to register into the application context.
     * @return the current builder instance
     */
    IntegrationFlowRegistrationBuilder addBean(Object bean);