public List<Object> getValues(Map<String, Object> map) {

    List<Object> retVal = new ArrayList<Object>();

    for (Map.Entry<String, Object> entry : map.entrySet()) {
        Object value = entry.getValue();

        if (value instanceof Map) {
            retVal.addAll(getValues((Map) value));
        } else {
            retVal.add(value);
        }
    }

    return retVal;
}