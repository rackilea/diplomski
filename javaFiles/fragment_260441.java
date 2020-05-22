ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
String[] beanNames = context.getBeanNamesForAnnotation(View.class);
for (String beanName : beanNames) {
    Object bean = context.getBean(beanName);
    View annotationOnBean = AnnotatedElementUtils.findMergedAnnotation(bean, View.class);
    System.out.println(annotationOnBean.name());
}