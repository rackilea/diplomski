@ParseClassName("Instrument")
public class Instrument extends ParseObject {
    public Instrument() {
    // A default constructor is required.
    }

    public InstrumentType getType() {
        return InstrumentType.parse(getString("type"));
    }
    public void setType(InstrumentType type) {
        put("type", type.toString());
    }