@Listeners(com.paypal.test.sample.testng.MyResultListener.class)
public class SampleTest {


    @Test
    public void test1(){

    Assert.assertTrue(true);

    }

    @Test
    public void test2() throws MyOwnException{

        throw new MyOwnException("Summa");

    }

}


This is how my results look:

PASSED: test1
FAILED: test2
com.paypal.test.sample.testng.MyOwnException: Summa
    at com.paypal.test.sample.testng.SampleTest.test2(SampleTest.java:25)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:606)
    at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:84)
    at org.testng.internal.Invoker.invokeMethod(Invoker.java:714)
    at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)
    at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)
    at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)
    at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)
    at org.testng.TestRunner.privateRun(TestRunner.java:767)
    at org.testng.TestRunner.run(TestRunner.java:617)
    at org.testng.SuiteRunner.runTest(SuiteRunner.java:334)
    at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)
    at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)
    at org.testng.SuiteRunner.run(SuiteRunner.java:240)
    at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
    at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
    at org.testng.TestNG.runSuitesSequentially(TestNG.java:1224)
    at org.testng.TestNG.runSuitesLocally(TestNG.java:1149)
    at org.testng.TestNG.run(TestNG.java:1057)
    at org.testng.remote.RemoteTestNG.run(RemoteTestNG.java:111)
    at org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:204)
    at org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:175)


===============================================
    Default test
    Tests run: 2, Failures: 1, Skips: 0
===============================================

My Own exception thrown

===============================================
Default suite
Total tests run: 2, Failures: 0, Skips: 0
===============================================