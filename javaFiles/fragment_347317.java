@Binders({ServiceBinder.class})
@RunWith(Hk2ClassRunner.class)
public class InjectTest {

    public static class Service {

        @Inject
        private Demo demo;

        public void doSomething() {
            System.out.println("Inside Service.doSomething()");
            demo.doSomething();
        }   
    }

    public static class Demo {
        public void doSomething() {
            System.out.println("Inside Demo.doSomething()");
        }
    }

    public static class ServiceBinder extends AbstractBinder {
        @Override
        protected void configure() {
            bind(Demo.class).to(Demo.class);
            bind(Service.class).to(Service.class);
        }
    }


    @Inject
    private Service service;

    @Test
    public void testInjections() {
        Assert.assertNotNull(service);
        service.doSomething();
    }
}