[TestNG] Running:
  C:\Users\USER_HP_2013_03\AppData\Local\Temp\testng-eclipse--1064112655\testng-customsuite.xml

Starting ChromeDriver 2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed) on port 10078
Only local connections are allowed.
Jan 04, 2017 5:10:03 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Attempting bi-dialect session, assuming Postel's Law holds true on the remote end
log4j:WARN No appenders could be found for logger (org.apache.http.client.protocol.RequestAddCookies).
log4j:WARN Please initialize the log4j system properly.
Jan 04, 2017 5:10:06 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: OSS
FAILED: testmethod
org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"class name","selector":"something"}
  (Session info: chrome=55.0.2883.87)
  (Driver info: chromedriver=2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed),platform=Windows NT 6.1.7601 SP1 x86_64) (WARNING: The server did not provide any stacktrace information)
Command duration or timeout: 42 milliseconds
For documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html
Build info: version: '3.0.1', revision: '1969d75', time: '2016-10-18 09:48:19 -0700'
System info: host: 'HP201303', ip: '192.168.56.1', os.name: 'Windows 7', os.arch: 'amd64', os.version: '6.1', java.version: '1.8.0_73'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Capabilities [{applicationCacheEnabled=false, rotatable=false, mobileEmulationEnabled=false, networkConnectionEnabled=false, chrome={chromedriverVersion=2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed), userDataDir=C:\Users\USER_H~1\AppData\Local\Temp\scoped_dir5260_26036}, takesHeapSnapshot=true, pageLoadStrategy=normal, databaseEnabled=false, handlesAlerts=true, hasTouchScreen=false, version=55.0.2883.87, platform=XP, browserConnectionEnabled=false, nativeEvents=true, acceptSslCerts=true, locationContextEnabled=true, webStorageEnabled=true, browserName=chrome, takesScreenshot=true, javascriptEnabled=true, cssSelectorsEnabled=true}]
Session ID: 92cbb27a874d7d2215eee51fc6a77819
*** Element info: {Using=class name, value=something}
    at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
    at sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)
    at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)
    at java.lang.reflect.Constructor.newInstance(Unknown Source)
    at org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)
    at org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)
    at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)
    at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)
    at org.openqa.selenium.remote.RemoteWebDriver.findElementByClassName(RemoteWebDriver.java:457)
    at org.openqa.selenium.By$ByClassName.findElement(By.java:391)
    at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)
    at SeleniumTests.testmethod(SeleniumTests.java:14)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
    at java.lang.reflect.Method.invoke(Unknown Source)
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
    at org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:132)
    at org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:236)
    at org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:81)


===============================================
    Default test
    Tests run: 1, Failures: 1, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Failures: 1, Skips: 0
===============================================

[TestNG] Time taken by org.testng.reporters.JUnitReportReporter@35bbe5e8: 9 ms
[TestNG] Time taken by org.testng.reporters.SuiteHTMLReporter@2a18f23c: 12 ms
[TestNG] Time taken by org.testng.reporters.jq.Main@4ec6a292: 27 ms
[TestNG] Time taken by org.testng.reporters.EmailableReporter2@3f0ee7cb: 9 ms
[TestNG] Time taken by [FailedReporter passed=0 failed=0 skipped=0]: 4 ms
[TestNG] Time taken by org.testng.reporters.XMLReporter@66d33a: 8 ms