Map<String, String[]> parameterMap = request.getParameterMap();
for (String key: parameterMap.keySet()) {
    if (key.startsWith("NUMBER_OF_")) {
        parameterKeyList.add(key); // add it to a list of parameters that are going to be
                                   // used for your Configuration instance
                                   // you know this is a good one because it has the prefix
    }
}

Map<String, Integer> maps = ...;

for (String parameter : parameterKeyList) {
    String value = request.getParameter(parameter); 
    Integer integer = Integer.parseInt(value);
    maps.put(parameter, integer);
}

Configuration config = new Configuration();
config.setMaps(maps);