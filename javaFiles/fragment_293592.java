@RunWith(...)
@Context...
public class YourTest {
    public static class TestConfiguration {
        @Bean
        @Primary
        public Database unwantedComponent(){
            return Mockito.mock(Database.class);
        }
    }

    @Test
    public void yourTest(){
        ...
    }
}