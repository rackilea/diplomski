import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

// ...

// Initialize Calendar service with valid OAuth credentials
Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credentials)
    .setApplicationName("applicationName").build();

// Iterate over the events in the specified calendar
String pageToken = null;
do {
  Events events = service.events().list('primary').setPageToken(pageToken).execute();
  List<Event> items = events.getItems();
  for (Event event : items) {
    System.out.println(event.getSummary());
  }
  pageToken = events.getNextPageToken();
} while (pageToken != null);