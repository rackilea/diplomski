public class Frame extends Model {
    @Id
    public Long id;

    @JsonIgnore
    @ManyToOne
    public Camera camera;

    @Transient
    @JsonProperty(value="camera")
    public Camera camera_id;
}