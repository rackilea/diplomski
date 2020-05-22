@Bean
public Client clientOne(@Qualifier("usageOne") SomeInterface usageOne) {
    return new Client(usageOne);
}

@Bean
public OtherClient clientTwo(@Qualifier("usageTwo") SomeInterface usageTwo) {
    return new OtherClient(usageTwo);
}