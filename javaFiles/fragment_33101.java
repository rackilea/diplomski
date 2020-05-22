private String combineCommands(String[] commands){
    String result = "";
    for(String command: commands){
        result = result + command + " && ";
    }
    if(result.length() > 0){
        result = result.subString(0,result.length()-3); // We remove the last && here.
    }
    return result;
}