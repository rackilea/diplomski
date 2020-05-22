SortedMap<Long, Double> newInner = Collections.synchronizedSortedMap(new TreeMap<Long, Double>());

flowStatTable.put(matchedFlow, newInner);

...

SortedMap<Long, Double> existingInner = flowStatTable.get(matchedFlow);

existingInner.put(checkPointTimeStamp, utilization);