public DateTime(int hours, int minutes, int seconds, int day, int month, int year) {
    this(hours, minutes, seconds);
    this.day = day;
    this.month = month;
    this.year = year;
}