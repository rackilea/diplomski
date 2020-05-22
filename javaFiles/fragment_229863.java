Optional<Instant> getJoinDate(final Instant instant) {
    final Optional<Employee> joinTime = empService.retrieveById(1);
    return joinTime.flatMap (emp -> {
        final Instant joinDate = emp.getJoinTime().toInstant();
        return joinDate.isBefore(instant.minus(20,ChronoUnit.YEARS)) ?
            Optional.of(instant.minus(20, ChronoUnit.YEARS)) :
            Optional.of(joinDate);
    });
}