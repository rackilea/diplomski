public static MultiMap<String, String> doDeserializationAndFormat(String serializedString) throws JsonParseException, JsonMappingException, IOException {
    MultiMap<String, String> source = doDeserialization(serializedString);
    MultiMap<String, String> result  =  new MultiValueMap<String,String>();
    for (String key: source.keySet()) {


        List allValues = (List)source.get(key);
        Iterator iter = allValues.iterator();

        while (iter.hasNext()) {
            List<String> datas = (List<String>)iter.next();

            for (String s: datas) {
                result.put(key, s);
            }
        }

    }

    return result;

}