Optional<Instant> getJoinDate(final Instant instant) {
    return empService.retrieveById(1).flatMap (emp -> 
            emp.getJoinTime().toInstant().isBefore(instant.minus(20,ChronoUnit.YEARS)) ?
            Optional.of(instant.minus(20, ChronoUnit.YEARS)) :
            Optional.of(emp.getJoinTime().toInstant()));
}