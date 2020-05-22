@Bean
public SomeBean myBean() {
    SomeBean bean = new SomeBean();
    bean.setProperty(EXAMPLE_CONSTANT);  // using a static import
    return bean;
}