public class Test {

    private MyObject myobject;
    private MyObject myDifferentObject;

    @Before
    public void initTest() {
        MockitoAnnotations.initMocks(this);
    myobject=createObject();
    myDifferentObject=createDifferentObject();
    }

    @Test
    private void test1{
        Mockito.when(defaultBuilder.build(service)).thenReturn(myobject);
    }

    @Test
    private void test2(){  
        Mockito.when(defaultBuilder.build(service)).thenReturn(myDifferentObject);
    }     

    }

//should work.