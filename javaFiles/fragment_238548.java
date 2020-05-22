@XmlRootElement
public class DriverJson {

    @XmlJavaTypeAdapter(UUIDAdapter.class)
    private UUID id;
    @XmlJavaTypeAdapter(UUIDAdapter.class)
    private UUID userId;

    /* ... */
}