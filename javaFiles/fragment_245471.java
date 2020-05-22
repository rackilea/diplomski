protected boolean fullTime;

public String getFullTimeAsString(){
    return Boolean.toString(fullTime);
}

public void setFullTimeAsString(String fulltimeStr){
    fullTime = "true".equalsIgnoreCase(fulltimeStr);
}