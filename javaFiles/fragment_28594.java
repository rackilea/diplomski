public void createEvent(Calendar cal) throws IOException {       

Event event = new Event();
event.setSummary("Event name here");
event.setLocation("event place here");

Date startDate = new Date();
Date endDate = new Date(startDate.getTime() + 3600000);
DateTime start = new DateTime(startDate, TimeZone.getTimeZone("UTC"));
event.setStart(new EventDateTime().setDateTime(start));
DateTime end = new DateTime(endDate, TimeZone.getTimeZone("UTC"));
event.setEnd(new EventDateTime().setDateTime(end));
Event createdEvent = cal.events().insert("primary", event).execute();
System.out.println("Created event id: " + createdEvent.getId());
}