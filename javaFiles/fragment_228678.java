// First access the TestFactory from the folder
ITestFactory iTestFact = iSubject.testFactory;

// Pull back a list of all tests.  Refer to OTA documentation on how to use filters on the list.
IList testList = iTestFact.newList();

// You can now iterate over the list of tests like you did subject folders