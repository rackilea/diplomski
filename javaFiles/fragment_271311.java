public static Map<String, Integer> total(List<MyObject> list) {
    Map<String, Integer> result = new HashMap<String, Integer>();

    for (MyObject myObject : list) {
        Integer prevValue = result.get(myObject.name);
        if (prevValue == null) {
            result.put(myObject.name, myObject.value);
        } else {
            result.put(myObject.name, myObject.value + prevValue);
        }
    }

    return result;
}