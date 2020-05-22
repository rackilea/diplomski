Map<String, String[]> parameterMap = request.getParameterMap();
for (String key: parameterMap.keySet()) {
    if (key.startsWith("subject_")) {
       // do what ever you want here 
    }
}