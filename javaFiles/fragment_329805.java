public enum TestType {

TEST_TYPE_1("TEST-1", Test1.class), 
TEST_TYPE_2("TEST-2", Test2.class), 
TEST_TYPE_3("TEST-3", Test3.class), 
TEST_TYPE_4("TEST-4", Test4.class), 
TEST_TYPE_5("TEST-5", Test5.class);

private final String testType;
private final Class<? extends TestIF> tester;

private <T extends TestIF> TestType(String testType, Class<? extends TestIF> tester)    {       
    this.testType = testType;
    this.tester = (Class<tester.TestIF>) tester;
}

public String toString() {
    return this.testType;
}

public Class<? extends TestIF> tester() {
    return this.tester;
}