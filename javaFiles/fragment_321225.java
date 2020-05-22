protected Map<String, String> yaml_parse(BufferedReader filename) throws IOException{
    String result;
    Map<String, String> map = new HashMap<String, String>();
    while ((result = filename.readLine()) != null) {
        //keyValue[0] = key, keyValue[1] = value
        String[] keyValue = result.split(": "); 
        map.put(keyValue[0], keyValue[1]);
    }

    return map;
}