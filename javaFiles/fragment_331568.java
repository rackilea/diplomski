@XmlRootElement(name = "dataCase")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataStorage {
    private String data1;
    private String data2;
    private String data3;

    /**
     * No-arg ctor needed by jaxb.
     */
    private DataStorage() {}

    public DataStorage(String data1, String data2, String data3) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

}