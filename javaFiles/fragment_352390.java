* Outputs this date-time as a {@code String}, such as
 * {@code 2007-12-03T10:15:30+01:00[Europe/Paris]}.
 * <p>
 * The format consists of the {@code LocalDateTime} followed by the {@code ZoneOffset}.
 * If the {@code ZoneId} is not the same as the offset, then the ID is output.
 * The output is compatible with ISO-8601 if the offset and ID are the same.