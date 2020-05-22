@RunWith(MockitoJUnitRunner.class)
public class MyTestClass {

    @Captor
    private ArgumentCaptor<List<B>> captor; //No initialisation here, will be initialized automatically

    @Test
    public testMethod() {
        //Testing...
        verify(someMock).someMethod(same(otherObject), captor.capture());
        assertThat(captor.getValue(), hasSize(2));
    }
}