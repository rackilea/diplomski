try {
    // create a new JSONParser
    JSONParser parser=new JSONParser();
    // first JSON decoding
    Object obj = parser.parse(everything);
    // second JSON decoding
    obj = parser.parse(obj.toString());
    // cast the parsed JSON string to a new JSONArray
    JSONArray array = (JSONArray)obj;
    // loop through each line of the initial JSONArray
    for (int i = 0; i < array.size(); i++){
        // write the array values as a single line
        System.out.println(i + " : " + array.get(i));
        // parsing each line as a new JSONArray
        JSONArray tmp = (JSONArray)parser.parse(array.get(i).toString());
        for (int j = 0; j < tmp.size(); j++){ // iterate over the parsed values
            System.out.println(i+"."+j+" : "+tmp.get(j));
        }
    }
} catch (ParseException ex) {
    Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
}