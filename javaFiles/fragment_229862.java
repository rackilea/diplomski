Optional<Instant> getJoinDate(final Instant instant) {
    final Optional<Employee> joinTime = empService.retrieveById(1);
    return joinTime.flatMap (emp -> {
        final Instant joinDate = emp.getJoinTime().toInstant();
        if (joinDate.isBefore(instant.minus(20,ChronoUnit.YEARS))) {
            return Optional.of(instant.minus(20, ChronoUnit.YEARS));
        }
        else {
            return Optional.of(joinDate);
        }
    });
}