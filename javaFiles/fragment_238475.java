private Map<String, List<String>> readValues(BufferedReader reader) throws IOException {
    Map<String, List<String>> nameToValuesMap  = new HashMap<String, List<String>>();
    String line = null;
    String actName = null; 
    while((line = reader.readLine()) != null) {
        if(line.startsWith("Name")) {
            String[] split = line.split("\\s*=\\s*", 2);
            String name = split[1];
            int i = name.indexOf('_');
            if(i != -1) {
                name = name.substring(0, i);
            }
            actName = name;
        } else if(line.startsWith("Value")) {
            String[] split = line.split("\\s*=\\s*", 2);
            String value = split[1].replace("0x", "");
            if(actName != null) {
                List<String> values = nameToValuesMap.get(actName);
                if(values == null) {
                    values = new ArrayList<String>();
                    nameToValuesMap.put(actName, values);
                }
                values.add(value);
            }
        }
    }

    return nameToValuesMap;
}