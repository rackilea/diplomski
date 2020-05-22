public class GUID {

    private final UUID uuid;

    public GUID() {
        this.uuid = UUID.randomUUID();
    }

    @XmlValue
    public String getValue(){
        return uuid.toString();
    }
}