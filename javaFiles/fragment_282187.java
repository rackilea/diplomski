public static void main(String[] args) {
   ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

   HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
   helloWorld.setMessage("Hello World!");
   helloWorld.getMessage();
}