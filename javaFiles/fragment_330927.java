public MyApp() {
    System.out.println("myapp construtor");  
    Injector.getInstance().initialize(this);
    Injector.getInstance().inject(this);

}