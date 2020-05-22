public class IterableProviderTest {

    public static interface Service {}

    public static class ServiceOne implements Service {}

    @QualAnno
    public static class ServiceTwo implements Service {}

    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface QualAnno {
        public static class Instance 
                extends AnnotationLiteral<QualAnno> implements QualAnno {
            public static QualAnno get() {
                return new Instance();
            }
        }
    }

    public class Binder extends AbstractBinder {
        @Override
        protected void configure() {
            bind(ServiceOne.class).to(Service.class).named("one");
            bind(ServiceTwo.class).to(Service.class).qualifiedBy(QualAnno.Instance.get());
        }  
    }

    @Inject
    private IterableProvider<Service> services;

    @Test
    public void test_IterableProvider() {
        ServiceLocator locator = ServiceLocatorUtilities.bind(new Binder());
        locator.inject(IterableProviderTest.this);

        assertEquals(2, services.getSize());

        Service serviceOne = services.named("one").get();
        assertTrue(serviceOne instanceof ServiceOne);

        Service serviceTwo = services.qualifiedWith(QualAnno.Instance.get()).get();
        assertTrue(serviceTwo instanceof ServiceTwo);  
    }
}