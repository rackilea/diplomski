public abstract class AbstractFakeApplicationTest extends WithApplication
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFakeApplicationTest.class);

    @Override
    protected Application provideApplication()
    {
        return new GuiceApplicationBuilder().in(Mode.TEST)
                                            .build();
    }

    @Override
    public void startPlay()
    {
        super.startPlay();
        // mock or otherwise provide a context
        Http.Context.current.set(new Http.Context(1L,
                                                  Mockito.mock(RequestHeader.class),
                                                  Mockito.mock(Http.Request.class),
                                                  Collections.<String, String>emptyMap(),
                                                  Collections.<String, String>emptyMap(),
                                                  Collections.<String, Object>emptyMap()));
    }

    public Http.Context context()
    {
        return Http.Context.current.get();
    }
}