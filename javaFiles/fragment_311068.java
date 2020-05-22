private boolean isURLValid(String url){
    if(Patterns.WEB_URL.matcher(url).matches()){
        return true;
    }
    //Show your warning message or whatever you want
    return false;
}