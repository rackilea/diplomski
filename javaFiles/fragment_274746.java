@RunWith(MockitoJUnitRunner.class)
public class MyAppTest { 

    @Mock private OpportunitiesService mocked_m_oppsSvc;
    @InjectMocks MyApp myApp;

    @Test public void when_MyApp_uses_OpportunititesService_then_verify_something() { 
        // given
        given( mocked_m_oppsSvc.whatever()).willReturn(...);

        // when
        myApp.isUsingTheOpportunitiesService(...);

        // then
        verify...
        assertThat...
    }
}