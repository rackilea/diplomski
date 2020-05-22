public void onFinish(ISuite isuite) {
        Map<String , ISuiteResult>  result =     isuite.getResults();
        Set<String> suites = result.keySet();
        for (String string : suites) {
            System.out.println(string);
        }
    }