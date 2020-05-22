@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootDemoApplicationTests
{  
    @Test
    public void testSomething() {
       // ...
    }

    @TestConfiguration
    static class MyTestConfiguration {

        //tests specific beans
        @Bean
        DataSource createDataSource(){
            //
        }
    }
}