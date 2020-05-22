class MyObject{
    public String cos;

    public MyObject(String cos) {
        this.cos = cos;
    }

    public boolean xyz() {
        return true;
    }
}

class A {
    protected MyObject a;

    public A() {
        a = new MyObject("ggggg");
    }

    public String doSomethingWithA(){
        if(a.xyz()){
            return a.cos;
        }
        else{
            return "aaaa";
        }
    }
}

@RunWith(MockitoJUnitRunner.class)
public class B  {

    @Mock
    MyObject mock_object;

    @InjectMocks
    A systemUnderTest = new A();

    @Test
    public void mockTest1() {
        Mockito.doReturn(false).when(mock_object).xyz();
        assertThat(systemUnderTest.doSomethingWithA()).isEqualTo("aaaa");
    }
    @Test
    public void mockTest2() {
        Mockito.doReturn(true).when(mock_object).xyz();
        assertThat(systemUnderTest.doSomethingWithA()).isNull();
    }

}