public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    startup = context.getBean(Startup.class);
    startup.start();
}

private void start() {
    myHandler.run();
}