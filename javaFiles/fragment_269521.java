public static void main(String[] args) {
    Map<String, Boolean> inputsAndExpectedResults = new HashMap<>();

    inputsAndExpectedResults.put("1234", false);
    inputsAndExpectedResults.put("4321", false);
    inputsAndExpectedResults.put("1122", true);
    inputsAndExpectedResults.put("8143", true);
    inputsAndExpectedResults.put("1265", true);
    inputsAndExpectedResults.put("9233", true);
    inputsAndExpectedResults.put("9137", true);
    inputsAndExpectedResults.put("2222", false);
    inputsAndExpectedResults.put("4333", false);
    inputsAndExpectedResults.put("5421", true);
    inputsAndExpectedResults.put("6667", false);
    inputsAndExpectedResults.put("4569", false);
    inputsAndExpectedResults.put("1272", true);

    Set<String> keySet = inputsAndExpectedResults.keySet();
    for(String key : keySet) {
        Boolean expectedValue = inputsAndExpectedResults.get(key);

        boolean result = isPasswordValid(key);
        String output = String.format("isPasswordValid(%s) returned %b expected %b", key, result, expectedValue);
        if(expectedValue.equals(result))
            System.out.println(output);
        else
            System.err.println(output);
    }
}