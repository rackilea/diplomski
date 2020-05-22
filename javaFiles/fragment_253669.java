public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println("Hit 'Enter' to terminate");
        System.in.read();
        ctx.close();
}