// Ideally use an injectable clock...
LocalDate today = new LocalDate();
// If this is effectively constant, extract it to a final static field
LocalTime time = new LocalTime(1, 0);

// Or use toDateTime(...) depending on what you're trying to accomplish
LocalDateTime todayAtTime = today.toLocalDateTime(time);