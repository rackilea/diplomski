@RunWith(PowerMockRunner.class)
@PrepareForTest({ Class2.class, Class1.class })
public class ClassTest {

    @Test
    public void runMethod() throws Exception {
        Class2 class2 = new Class2();
        Class1 class1 = PowerMockito.mock(Class1.class);

        PowerMockito.whenNew(Class1.class).withAnyArguments().thenReturn(class1);
        PowerMockito.when(class1.mockTestMethod(Mockito.anyString())).thenReturn("MOCKED VALUE");
        class2.testingMethod();
    }

}