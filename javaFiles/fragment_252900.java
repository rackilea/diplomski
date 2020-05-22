@RunWith(SpringRunner.class)
@SpringBootTest(classes = YourApp.class)
public class MyServiceUnitTest {

    @MockBean
    private MyServiceFeign myFeignClient;

    @Autowiered
    private MyService myService;

    @Test
    public void testSync() {
        given(myFeignClient.getByKey("SomeKey")).willReturn(
            new SomePojo("SomeKey")
        );
        assertEquals("SomeKey", myService.doStuff().getKey());
    }
}