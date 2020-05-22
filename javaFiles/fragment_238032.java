List<Long> timestamps = new ArrayList<Long>();
long currentTimestamp = (long) (System.currentTimeMillis() / 1000L);

int hourRange = 8;    
int n_timestamps = 5;
double timePeriod = hourRange / (n_timestamps + 0.0);
Random rand = new Random();

for (int i = 0; i < n_timestamps; i++) {
    long startTimestamp = addHoursToTimestamp(i, currentTimestamp);
    long endTimestamp = addHoursToTimestamp(timePeriod, startTimestamp);

    Long randomTime = startTimestamp + Math.abs(rand.nextLong()) % (endTimestamp-startTimestamp);
    timestamps.add(randomTime);
}