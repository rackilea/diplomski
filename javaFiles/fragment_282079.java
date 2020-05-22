public int compareTo(Object o) {
    MyDate otherDate = (MyDate) o;
    int thisYear = this.getYear();
    int otherYear = otherDate.getYear();
    if (thisYear < otherYear) return -1;
    if (thisYear > otherYear) return 1;
    // Now try the month, then day etc
}