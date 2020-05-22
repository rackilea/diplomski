@Data
@NoArgsConstructor
@Entity
@Table(name = "locations")
@IdClass(Location.PK.class )
public class Location {

    @Id private Long locationId;
    @Id private String locationName;

    public PK getId() {
        return new PK(locationId, locationName);
    }

    public void setId(PK id) {
        this.locationId = id.getLocationId();
        this.locationName = id.getLocationName();
    }

    public Location(final Long locationId, final String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PK implements Serializable {
        private Long locationId;
        private String locationName;
    }
}