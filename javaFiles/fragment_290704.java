Util.register(new thingICantChange(){
    @Override
    protected void configure (){
        super.configure();
        bind(ConfigurationService.class).to(ConfigServiceTest.class).asEagerSingleton();
    }
});

class1 service = new class1();

service.start();
Assert.assertEquals(true, true);