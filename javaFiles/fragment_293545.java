public JSONArray extractData(String filename){
    JSONArray jsonArray = new JSONArray();
    ArrayList<String> lines = readAllLines(filename);

    //For each line of the original text file, add the JSONObject to the JSONArray
    for (String line : lines)
        jsonArray.add(convertToJson(line));

    return jsonArray;
}