private Boolean canCheckin(LocalDateTime nextValidCheckinTime){
        return timeFactory.now().isAfter(nextValidCheckinTime);
    }

    private LocalDateTime nextValidCheckinTime(LocalDateTime lastCheckinDate){
        LocalTime checkinTime = LocalTime.of(7, 59, 59);

        if (lastCheckinDate.toLocalTime().isBefore(checkinTime)) {
            return lastCheckinDate.withHour(7).withMinute(59).withSecond(0);
        } else {
            return lastCheckinDate.plusDays(1).withHour(7).withMinute(59).withSecond(59);
        }
    }