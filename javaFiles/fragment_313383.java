public class ServiceTest extends TransactionalTest {
    @InjectMocks
    HistoryService orderHistoryService;

    @Mock
    WebsiteService websiteService;

    ...

}