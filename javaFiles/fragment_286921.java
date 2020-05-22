public class Show {
private int showId;
private int siteId;
private String name;
private int duration;
private int providerId;
private List<Events> events;

//getters and setters

@Override
public String toString() {
    return "Show{" +
            "showId=" + showId +
            ", siteId=" + siteId +
            ", name='" + name + '\'' +
            ", duration=" + duration +
            ", providerId=" + providerId +
            ", events=" + events +
            '}';
     }
}