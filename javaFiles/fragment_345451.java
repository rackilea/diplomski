public Clock ( int InsertSeconds, int InsertMinutes, int InsertHours){
    if (InsertSeconds > 59 || InsertSeconds < 0) {
         throw new IllegalArgumentException("InsertSeconds must be in range 0-59 but found "+ InsertSeconds);
    }
    // similar for minutes & hours

    seconds = InsertSeconds;
    minutes = InsertMinutes;
    hours   = InsertHours;
}