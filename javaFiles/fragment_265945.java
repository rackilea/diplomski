Map<DateTime,Integer> rawCount = ....
DateTime start = ....
long duration = 1*60*60*1000;

DateTime lastDate = start;
// find the last date
for (DateTime dateTime : rawCount.keySet()) {
    if (dateTime.isAfter(lastDate))
        lastDate = dateTime;
}
int intervals = (int) ((lastDate.getMillis() - start.getMillis())/duration) + 1;
int[] counts = new int[intervals];
for (Map.Entry<DateTime, Integer> entry : rawCount.entrySet()) {
    DateTime key = entry.getKey();
    int interval = (int) ((key.getMillis() - start.getMillis()) / duration);
    counts[interval] += entry.getValue(); 
}