@Bean
public IntegrationFlow flow() {...}


...


@Autowired
public IntegrationFlow flow;

...

flow.stop();