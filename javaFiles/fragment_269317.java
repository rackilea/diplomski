public class VelocityParserTest {
    public static void main(String[] args) throws IOException {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(PoenaRequestService.class).asEagerSingleton();
                bind(HttpService.class)
                    .annotatedWith(Names.named("poena_service"))
                    .toInstance(...);
            }
        });

        try {
            PoenaRequestService poenaService = injector.getInstance(PoenaRequestService.class);
            System.out.println(poenaService.sendRequest("kbkCode"));
        } catch (PoenaServiceException e) {
            e.printStackTrace();
        }
    }
}