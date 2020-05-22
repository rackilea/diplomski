public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication();
    springApplication.setListeners(Collections.singleton(new MyListener()));
    springApplication.setSources(MyApplication.class);
    springApplication.run(args) ///!!!!!
}