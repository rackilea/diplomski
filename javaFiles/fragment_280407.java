@RunWith(PowerMockRunner.class)
@PrepareForTest({ MyStaticClass.class })
public class MyTest {

    @Before 
    public void setup() {
        // Here you mock the variable with the method that is going to be executed    
        PowerMockito.mockStatic(MyStaticClass.class);
        PowerMockito.when(MyStaticClass.staticMethod).thenReturn(result);
    }

}