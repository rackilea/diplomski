import java.io.Serializable;

public class Action implements Serializable
{

    private String id;
    private String deviceId;
    private String errorReport;
    private String name;
    private long state;
    private long value;
    private ValueOption valueOption;
    private boolean valueable;
    private final static long serialVersionUID = 3493217442158516855L;

    public String getId() {
        return id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getErrorReport() {
        return errorReport;
    }

    public String getName() {
        return name;
    }

    public long getState() {
        return state;
    }

    public long getValue() {
        return value;
    }

    public ValueOption getValueOption() {
        return valueOption;
    }

    public boolean isValueable() {
        return valueable;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setErrorReport(String errorReport) {
        this.errorReport = errorReport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(long state) {
        this.state = state;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setValueOption(ValueOption valueOption) {
        this.valueOption = valueOption;
    }

    public void setValueable(boolean valueable) {
        this.valueable = valueable;
    }
}