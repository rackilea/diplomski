Event event = new Event();

event.setSummary("Appointment");
event.setLocation("Somewhere");

ArrayList<EventAttendee> attendees = new ArrayList<EventAttendee>();
attendees.add(new EventAttendee().setEmail("attendeeEmail"));
// ...
event.setAttendees(attendees);

Date startDate = new Date();
Date endDate = new Date(startDate.getTime() + 3600000);
DateTime start = new DateTime(startDate, TimeZone.getTimeZone("UTC"));
event.setStart(new EventDateTime().setDateTime(start));
DateTime end = new DateTime(endDate, TimeZone.getTimeZone("UTC"));
event.setEnd(new EventDateTime().setDateTime(end));

Event createdEvent = service.events().insert("primary", event).execute();

System.out.println(createdEvent.getId());