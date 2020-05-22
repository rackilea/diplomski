static int getMaximumMeetings(List<Integer> start, List<Integer> timeTaken) {
    List<Interval> list = new ArrayList<>(); // create a List of Interval
    for (int i = 0; i < start.size(); i++) {
        list.add(new Interval(start.get(i), start.get(i) + timeTaken.get(i)));
    }
    list.sort(Comparator.comparingInt(i -> i.end)); // sort by finish times ascending

    int res = 0;
    int prevEnd = Integer.MIN_VALUE; // finish time of the previous meeting

    for (Interval i : list) {
        if (i.start >= prevEnd) { // is there a conflict with the previous meeting?
            res++;
            prevEnd = i.end; // update the previous finish time
        }
    }
    return res;
}