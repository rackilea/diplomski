@ExtendWith(MockitoExtension.class)
public class SomeTestClass {

    private static class MyService {
        public void error(Optional<String> op, String msg1, String msg2) {

        }
    }

    @Test
    void testMethod() {
        MyService myService = Mockito.mock(MyService.class);
        myService.error(Optional.empty(), "This is error", "Some error appeared");
        Mockito.verify(myService, Mockito.times(1)).error(Mockito.any(), Mockito.eq("This is error"), Mockito.contains("error"));
    }
}