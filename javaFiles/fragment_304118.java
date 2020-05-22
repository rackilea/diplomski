public class Characteristic extends JAXBElement<String> {
    private static final long serialVersionUID = 1L;
    public static final QName NAME = new QName("characteristic");

    public Characteristic(String value) {
        super(NAME, String.class, value);
    }

    public Characteristic(String characteristic, String value) {
        super(NAME, String.class, value);
        this.characteristic = characteristic;
    }

    @Override
    public QName getName() {
        final String characteristic = getCharacteristic();
        if (characteristic != null) {
            return new QName(characteristic);
        }
        return super.getName();
    }

    private String characteristic;

    @XmlTransient
    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
}