Map<String,String> processParams(String list) {
    Map<String,String> = new HashMap<String,String>();
    int openBracket = list.indexOf("{");
    int closeBracket = list.lastIndexOf("}");
    String params = list.substring(openBracket+1,closeBracket);
    String paramList = params.split(",");

    for(String param: paramList) {
       String pData = param.trim().split(":");
       map.put(param[0].trim(),param[1].trim());
    }
    return map;
}

processParams("{22:4, id:amount}");