String input = "$key1=value1\n" +
        "$key2=value2 value21\n" +
        "value22\n" +
        "$key3=value3";

Pattern keyValuePattern = Pattern.compile("\\$(\\w+)=((\\w+\\s*)+)");
Matcher keyValueMatcher = keyValuePattern.matcher(input); // get a matcher object
Map<String, List<String>> map = new HashMap<String, List<String>>();
while (keyValueMatcher.find()) {
    String key = keyValueMatcher.group(1);
    List<String> values;
    values = Arrays.asList(keyValueMatcher.group(2).split("\\s+"));
    //If you want to update your lists later comment the line above and uncomment those two
    //values = new ArrayList<String>();
    //values.addAll(Arrays.asList(keyValueMatcher.group(2).split("\\s+")));

    map.put(key, values);
}

System.out.println(map); // {key3=[value3], key2=[value2, value21, value22], key1=[value1]}