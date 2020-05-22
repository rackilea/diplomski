private Map asLowerCaseIndexedMap(DynaBean bean) {
    Map lowerCaseIndexedMap = new HashMap();
    DynaProperty[] dynaProperties = bean.getDynaClass().getDynaProperties();

    for (int i=0, n=dynaProperties.length; i<n; i++) {
        String propertyName = dynaProperties[i].getName();
        lowerCaseIndexedMap.put(propertyName.toLowerCase(), bean.get(propertyName));
    }

    return lowerCaseIndexedMap;
}