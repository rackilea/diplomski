String[] keyArray = { "one", "two", "three" };
String[] valArray = { "foo", "bar", "bazzz" };

// create a new HashMap that maps Strings to Strings

Map<String, String> exampleMap = new HashMap<String, String>();

// create a map from the two arrays above

for (int i = 0; i < keyArray.length; i++) {
    String theKey = keyArray[i];
    String theVal = valArray[i];
    exampleMap.put(theKey, theVal);
}

// print the contents of our new map

for (String loopKey : exampleMap.keySet()) {
    String loopVal = exampleMap.get(loopKey);
    System.out.println(loopKey + ": " + loopVal);
}