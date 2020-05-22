/** Returns a generic map which all keys are string but not values **/
T <T extends Map> raw(Class<T> clazz) {
    Map object = new LinkedHashMap();
    object.put("string", "This is a String");
    object.put("map"   , new LinkedHashMap());
    return (T) object;
}