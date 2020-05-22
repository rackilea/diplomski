@Before
public void setUp() throws Exception {
    Map<String, String> flashData = Collections.emptyMap();
    Map<String, Object> argData = Collections.emptyMap();
    Long id = 2L;
    play.api.mvc.RequestHeader header = mock(play.api.mvc.RequestHeader.class);
    Http.Context context = new Http.Context(id, header, request, flashData, flashData, argData);
    Http.Context.current.set(context);
}