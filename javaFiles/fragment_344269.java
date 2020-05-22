public String whatTime(int seconds) {

    int secondVal = seconds % 60;
    int minutes = seconds / 60;
    int minuteVal = minutes % 60;
    int hours = minutes / 60;
    int hourVal = hours % 24;
    int daysVal = hours / 24;

    String answer = "" + daysVal + ":" + hourVal + ":" + minuteVal + ":" + secondVal;

    return answer;
}