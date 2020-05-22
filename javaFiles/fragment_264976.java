public abstract class BaseTestClass {

@ClassRule public static TestClassName className = new TestClassName();
@Rule public TestName testName = new TestName();    

  @BeforeClass public static void 
printClassName() { 
        System.out.println("--" + className.getClassName() + "--"); 
    }    
  @Before public void 
printMethodName() {
        System.out.print(" " + testName.getMethodName()); 
    }    
  @After public void 
printNewLine() { 
        System.out.println(); 
    }
}