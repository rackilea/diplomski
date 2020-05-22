Map<Integer, Map<String, Long>> map = 
    monitoredData.stream()
                 .collect(Collectors.groupingBy (
                      e -> e.getStartTime().dayOfMonth(),
                      Collectors.groupingBy(MonitoredData::getActivity,
                                            Collectors.counting())));