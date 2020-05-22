Map<String, Map<Integer,Double>> valueMap =
    new HashMap<String, Map<Integer,Double>>();

while (...reading in and processing data...) {
    int ticketId = ...;
    String sourceName = ...;
    double entryValue = ...;

    Map<Integer,Double> sourceNameMap = valueMap.get(sourceName);
    Double value = sourceNameMap.get(ticketId);
    if (oldValue == null) {
        value = entryValue;
    } else {
        value += entryValue;
    }
    sourceNameMap.put(ticketId, value);
}