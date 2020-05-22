public JSONObject convertToJsonObject(String line){
    //Convert String into an ArrayList, split by "|" delimiter
    ArrayList<String> dataParts = new ArrayList<>(Arrays.asList(line.split("\\|")));
    String date=null;
    JSONObject jsonObj = new JSONObject();

    //Get the date, wherever it might be in the String and remove it from the List
    for(int i=0; i<dataParts.size(); i++){
        if (isValidDate(dataParts.get(i))){
            date = dataParts.get(i);
            dataParts.remove(i);
            break;
        }
    }
    //Add the date with key "date"
    jsonObj.put("date", date);
    //Add the rest of the data, with key "data" (while preserving the order)
    jsonObj.put("data", String.join("|", dataParts));

    return jsonObj;
}