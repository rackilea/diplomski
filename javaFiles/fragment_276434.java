Method[] exampleMethods = Example.class.getMethods();
Map<String, Method> setterMethodsByPropertyName = new HashMap<>(exampleMethods.length);
for (Method exampleMethod : exampleMethods) {
  String methodName = exampleMethod.getName();
  if (!methodName.startsWith("set")) {
    continue;
  }
  // substring starting right after "set"
  String variableName = methodName.substring(3);
  // use lowercase here because:
  // 1. JSON property starts with lower case but setter name after "set" starts with upper case
  // 2. property names should all be different so no name conflict (assumption)
  String lcVariableNmae = variableName.toLowerCase();
  setterMethodsByPropertyName.put(lcVariableName, exampleMethod);
}

// later in the code, and assuming that your JSON map is accessible via a Java Map
for (Map.Entry<String, ?> entry : jsonMap.entrySet()) {
  String propertyName = entry.getKey();
  String lcPropertyName = propertyName.toLowerCase();
  if(!setterMethodsByPropertyName.containsKey(lcPropertyName)) {
    // do something for this error condition where the property setter can't be found
  }
  Object propertyValue = entry.getValue();
  Method setter = setterMethodsByPropertyName.get(lcPropertyName);
  setter.invoke(myExampleInstance, propertyValue);
}