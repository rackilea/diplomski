protected Flight(String scheduledTime, String eventType, String identifier) {
    this.identifier = identifier;
        this.actualTime = null;
        this.runwayUsed = null;    
        this.scheduledTime = LocalTime.parse(scheduledTime);
        this.eventType = EventType.valueOf(eventType);      
}