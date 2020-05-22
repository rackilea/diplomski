String testName = "...";
MDC.put("testName", testName);

// run your test
// ...

// remove the test name from MDC ready for the next test to set its own name
MDC.remove("testName");