private <In, Out> void checkMapping(Map<String, Object> objectMap, 
                                    In object, 
                                    List<DataGetter<In, Out>> objectDataGetters) {
    for(DataGetter<In, Out> getter : objectDataGetters) {
        String key = getter.getDataName();
        Out value = getter.getData(object);

        List<DataGetter<Out, ?>> valueGetters = getter.getOutGetters();
        if(valueGetters.size() == 0) {
            //Check mapping is correct
            assertThat(objectMap.get(key), isValue(value));
        } else {
            //Recursion
            try {
                Map<String, Object> valueMap = (Map<String, Object>) objectMap.get(key);
                checkMappingRecursive(valueMap, value, valueGetters); 
            } catch (ClassCastException e) {
                fail();
            }
        }
    }
}