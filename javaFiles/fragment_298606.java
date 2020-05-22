@RunWith(MockitoJUnitRunner.class)
    public class KajmanControllerTest {

        @Mock
        private KajmanInfoService kajmanInfoService ;

        @InjectMocks
        private KajmanController controller;

        @Test
        public void customerInfoRetrieved() {
            //some logic
            when(kajmanInfoService.getInfo(anyString()).thenReturn(expectedInfo);
            //some logic
            String[] expectedInfoArguments = {"A1","B1","C1"};
            controller.getInfo(expectedInfoArguments);
            verify(kajmanInfoService, times(3)).getInfo(anyString);
        }
    }