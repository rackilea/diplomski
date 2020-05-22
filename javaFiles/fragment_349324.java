JSONObject postParameters = new JSONObject();
Map parameterMap = httpRequest.getParameterMap();
for (Map.Entry<String,String[]> entry : parameterMap.entrySet()){
    if(entry.getValue().length == 1){
        postParameters.put(entry.getKey(), entry.getValue()[0].toString());
    }
    else{
        JSONArray valueList = new JSONArray();
        for(String value : entry.getValue()){
            valueList.add(value.toString());
        }
        postParameters.put(entry.getKey(), valueList);
    }
}