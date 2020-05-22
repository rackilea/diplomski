public static void main(String[] args){
    List tests = new ArrayList();
    tests.add(TestOne.class);
    tests.add(TestTwo.class);

    for (Class test : tests){
        runTests(test);
    }
}

private static void runTests(Class test){
    Result result = JUnitCore.runClasses(test);
    for (Failure failure : result.getFailures()){
        System.out.println(failure.toString());
    }
}