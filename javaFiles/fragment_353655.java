SeverityCount calculateSeveritiesCount(List<? extends SeverityCalculable> events) {

    if(null == events){
        return new SeverityCount();
    }

    Map<String, Long> severityCountMap = events.stream().collect(
        Collectors.groupingBy(
            SeverityCalculable::getSeverity,
            Collectors.counting()
        )
    );

    return mapper.convertValue(severityCountMap, SeverityCount.class);
}