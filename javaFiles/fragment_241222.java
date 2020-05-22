Alert alert = Alert.builder().field1("foo").field2("bar").lastOccurence(new Date()).build();
Optional<Alert> dbAlert = alertRepository.findOne(Example.of(alert));
if (dbAlert.isPresent()) {
    // update
} else {
    // insert
}