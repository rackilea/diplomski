public Date() {
    this(0, 0, 0);
}

public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;

    if ( year > 0 && month > 0 && month < 13 && day > 0 && day < 32) {  
        checked = "valid";
    }
    else {
        checked = "invalid";
    }
}