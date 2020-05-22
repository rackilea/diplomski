private Map<String, Object> map(DataPoint dataPoint) {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("x", dataPoint.timeStamp);
    map.put("y", dataPoint.value);
    return map;
}


List<List<Map<String, Object>>> transformedObject = dataSets.stream()
            .map(
                    dataSet -> dataSet.dataPoints.stream()
                        .map(this::map)
                        .collect(Collectors.toList())
                )
            .collect(Collectors.toList());