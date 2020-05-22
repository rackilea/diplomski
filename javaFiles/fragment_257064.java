Map<String, String> myMap = new HashMap<String, String>();

String varName = getVariableNameFromUser();
String value = getValueFromUser();

myMap.put(varName, value);


// ... later


String whatVariableDoYouWantTheValueOf = getVarNameFromUser();
String storedValue =  myMap.get(whatVariableDoYouWantTheValueOf);
System.out.println("The value for that is: " + storedValue);