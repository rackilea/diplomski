public class Events {
private int siteId;
private int eventSiteId;
private int providerId;
private int eventId;
private int hallId;
private boolean premiere;
private String origin;

// getters and setters

@Override
public String toString() {
    return "Events{" +
            "siteId=" + siteId +
            ", eventSiteId=" + eventSiteId +
            ", providerId=" + providerId +
            ", eventId=" + eventId +
            ", hallId=" + hallId +
            ", premiere=" + premiere +
            ", origin='" + origin + '\'' +
            '}';
   }
 }