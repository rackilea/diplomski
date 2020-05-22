LocalDateTime.ofInstant(Instant.ofEpochMilli(lastModification),
                        TimeZone.getDefault().toZoneId());

// OR using ZoneId

LocalDateTime.ofInstant(Instant.ofEpochMilli(lastModification),
                        ZoneId.systemDefault());
LocalDateTime.ofInstant(Instant.ofEpochSecond(lastModification),
                        ZoneId.systemDefault());