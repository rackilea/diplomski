CalendarUrl url = new CalendarUrl(calendar.getEventFeedLink());
try {
  EventFeed feed = client.eventFeed().list().execute(url);
  for(EventEntry entry : feed.getEntries()) {
    // etc....
  }
}
catch(IOException e) {
  e.printStackTrace();
}