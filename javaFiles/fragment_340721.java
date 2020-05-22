public static void main (String[] args) {
    int hour = getHours();
    char major = getMajor();
    char status =  getStatus();
    displayTuition(hour, major, status);
}

// other methods
...


public static displayTuition(int hour, char major, char status) {
    System.out.println("Credit Hours:" + hour);
    //etc
}