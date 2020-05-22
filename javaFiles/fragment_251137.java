@Bean
private SomeClass someclassBean() {
    SomeClass sc = new SomeClass();
    sc.setSomeName(Arrays.asList(new SomeOtherClass()));
    return sc;
}