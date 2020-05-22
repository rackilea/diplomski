protected Flight(String scheduledTime, String eventType, String identifier) {
        this.identifier = identifier;
        this.actualTime = null;
        this.runwayUsed = null;    
    try {
            this.scheduledTime = LocalTime.parse(scheduledTime);
        } catch(Exception e) {
            System.out.println(e + " Flight constructor - scheduledTime problem");
        } 
    try {
             this.eventType = EventType.valueOf(eventType);
        } catch(Exception e) {
            System.out.println(e + " Flight constructor - eventType problem");
        }
}