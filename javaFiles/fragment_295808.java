@Bean
@Autowired
RulesEngineFactoryBean rulesEngineFactoryBean(OverweightRule myOverweightRule){
    RulesEngineFactoryBean rules = new RulesEngineFactoryBean();
    rules.setRules(Arrays.asList(myOverweightRule));
    return rules;
}