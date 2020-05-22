//mocks
RssService mockRssService;

//system under test
RssListPresenter rssListPresenter;

@Before
public void setup() {
    mockRssService = Mockito.mock(RssService.class);
    rssListPresenter = new RssListPresenter(mockRssService);
}