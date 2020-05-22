public void execute ()  {
    Map<Double, List<Pair>> arrayMap = new HashMap<Double, List<Pair>>();
    while (resultSet.next()) {
        double timeStamp = resultSet.getDouble(1);
        double value = resultSet.getDouble(2);

        Double key = getPeriondStart(timeStamp);
        List<Pair> list = arrayMap.get(key);
        if (list == null) {
            list = new ArrayList<Pair>();
            arrayMap.put(key, list);
        }
        list.add(new Pair(timeStamp, value));
    }

    // arrayMap contains arrays separated by periods
}

// shrink parameter to Unix-Timestamp period (hour) begining
Double getPeriondStart(double timeStamp) {
    return ...;
}

class Pair {
    double timeStamp;
    double value;

    public Pair(double timeStamp, double value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}