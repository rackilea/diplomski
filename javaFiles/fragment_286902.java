public class MyTest {

    @Test
    public void test() throws Exception {

        ClassToTest classToTest = new ClassToTest();

        ClassA inputA = new ClassA();

        // trying to use powermock here just returns a NullPointerException
//      final Method mockMethod = PowerMockito.mock(Method.class);
        Method mockMethod = (new ClassToInvoke()).getClass().getMethod("someMethod");   // a real Method instance

        // regular mockito for mocking behaviour    
        ClassToInvoke mockClassToInvoke = mock(ClassToInvoke.class);
        classToTest.setClassToInvoke(mockClassToInvoke);

        MethodStore mockMethodStore = mock(MethodStore.class);
        classToTest.setMethodStore(mockMethodStore);

        when(mockMethodStore.getMethod(inputA)).thenReturn(mockMethod);

        MethodInvoker mockMethodInvoker = mock(MethodInvoker.class);
        classToTest.setMethodInvoker(mockMethodInvoker);

        when(mockMethodInvoker.invoke(mockMethod,mockClassToInvoke, inputA)).thenReturn(Boolean.TRUE);

        ObjectRunner mockObjectRunner = mock(ObjectRunner.class);
        classToTest.setObjectRunner(mockObjectRunner);

        // execute test method      
        classToTest.testMethod(inputA);

        verify(mockObjectRunner).run(inputA);   
    }
}