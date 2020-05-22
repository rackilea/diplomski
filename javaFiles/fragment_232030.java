@JsonTypeName("user")
public class User implements IdentityInterface
{
    private long id;

    @JsonProperty
    private String firstName;

    (...)

    @JsonProperty
    private List<Location> locations;
}
public class Location{
    private Long id;
    private Double latitude;
    private Double longitude;
    private Date timestamp;

    // Getters and setter
   (...)
}