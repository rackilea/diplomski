// First Test Case
Case mycase = new Case().setTitle("TEST TITLE").setSuiteId(suite.getId()).setSectionId(section.getId());
mycase = testRail.cases().add(mycase.getSectionId(), mycase, customCaseFields).execute();
// List for Test Cases
List<Integer> caseList = new ArrayList<>();
caseList.add(mycase.getId());
// Create new Entry and add the test cases
Entry entry = new Entry().setIncludeAll(false).setSuiteId(suite.getId()).setCaseIds(caseList);
entry = testRail.plans().addEntry(testPlan.getId(),entry).execute();
// Create the second test case
Case mycase2 = new Case().setTitle("TEST TITLE 2").setSuiteId(suite.getId()).setSectionId(section.getId());
mycase2 = testRail.cases().add(mycase.getSectionId(), mycase, customCaseFields).execute();
// Add the second test case to the list
caseList.add(mycase2.getId());
// Set in the Entry all the test cases and update the Entry
entry.setCaseIds(caseList);
testRail.plans().updateEntry(testPlan.getId(), entry).execute();