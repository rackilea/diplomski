private static final String YES = "yes";
private static final String NO = "no";
protected boolean fullTime;


public String isFullTimeAsString() {
    return fullTime? YES: NO;
}

public void setFullTime(String fullTime) {
    this.fullTime =YES.equalsIgnoreCase(fullTime);
}