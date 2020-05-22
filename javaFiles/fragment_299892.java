// Create TreeMap
NavigableMap<Integer, MyInterval> map = new TreeMap<>();

// Putting values
map.put(interval1.min(), myInterval);
map.put(interval2.min(), myInterval);

// Retrieving values
int value = 15;
MyInterval interval = map.floorEntry(value).getValue();

// Check if value is smaller than max()
if (value <= interval.max())
    return interval;
return null;