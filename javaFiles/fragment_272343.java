private void checkAndAssign(Map<String, Object> map, String paramName, String paramValue, Function<String, Object> checker){
  if(paramValue!=null){
    Object param = checker.apply(paramValue);
    map.put(paramName, param);
  }
}

public Result edit(String param1, String param2, String param3, String param4, String param5, String param6) {

    Map<String, Object> parameters = new HashMap<>();
    checkAndAssign(map, "param1", param1, MyClass::checkParam1);
    checkAndAssign(map, "param2", param2, MyClass::checkParam2);
    checkAndAssign(map, "param3", param3, MyClass::checkParam3);
    checkAndAssign(map, "param4", param4, MyClass::checkParam4);
    checkAndAssign(map, "param5", param5, MyClass::checkParam5);
    checkAndAssign(map, "param6", param6, MyClass::checkParam6);
    assert(parameters.size() > 0, "At least one parameter required");

    // [TREATMENT]
}