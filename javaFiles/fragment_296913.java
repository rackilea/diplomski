public Observation(String oneLine)
{
        String[] splitItems = oneLine.split(":");
        this.photoboxID = Integer.valueOf(splitItems[0]);
        this.passingTime = Long.valueOf(splitItems[1]);
        this.speedKMprHour  = Integer.valueOf(splitItems[2]);
        this.carID = splitItems[4];
}