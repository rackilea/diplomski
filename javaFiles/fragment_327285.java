ListMultimap<String, String> map = ArrayListMultimap.create();
    for (String id : annotation.ids()) {
        map.put(ITestResult.SUCCESS, id);
    }

    // getting all passed
    List<String> passedTestIds = map.get(ITestResult.SUCCESS);