import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.EventDateTime;

...

DateTime end = new DateTime(start.getDateTime().getValue() + 30L * 60L * 1000L);