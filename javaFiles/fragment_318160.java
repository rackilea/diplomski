public static void main(String[] args) throws Exception {
    final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(myConfiguration.class);
    final MyClass myclass = applicationContext.getBean("myClass");
    myclass.get("testKey");
    myclass.get("testKey");
    myclass.get("testKey");
}