public static List<TimeInterval> breakOverlappingIntervals( List<TimeInterval> sourceList ) {

    TreeMap<Date,Integer> endPoints = new TreeMap<>();

    // Fill the treeMap from the TimeInterval list. For each start point, increment
    // the value in the map, and for each end point, decrement it.

    for ( TimeInterval interval : sourceList ) {
        Date start = interval.getStart();
        if ( endPoints.containsKey(start)) {
            endPoints.put(start, endPoints.get(start) + 1);
        } else {
            endPoints.put(start, 1);
        }
        Date end = interval.getEnd();
        if ( endPoints.containsKey(end)) {
            endPoints.put(end, endPoints.get(start) - 1);
        } else {
            endPoints.put(end, -1);
        }
    }

    int curr = 0;
    Date currStart = null;

    // Iterate over the (sorted) map. Note that the first iteration is used
    // merely to initialize curr and currStart to meaningful values, as no 
    // interval precedes the first point.

    List<TimeInterval> targetList = new ArrayList<>();
    for ( Map.Entry<Date,Integer> e : endPoints.entrySet() ) {
        if ( curr > 0 ) {
            targetList.add(new TimeInterval(currStart, e.getKey()));
        }
        curr += e.getValue();
        currStart = e.getKey();
    }
    return targetList;
}