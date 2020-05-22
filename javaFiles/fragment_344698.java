public class SomeBeanMockProducer {
    @Produces @CDIMock
    public static SomeBean produce() {
        SomeBean someBean = Mockito.mock(SomeBean.class);
        Mockito.when(someBean.getText()).thenReturn("mocked");

        return someBean;
    }  
}