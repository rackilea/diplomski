public class Pojo {
    @JsonIgnore
    private String pin;

    @JsonProperty("pin")
    public String getPin() {
        if(pin == null) {
            return "";
        } else {
            return "***";
        }
    }

    @JsonProperty("pin")
    public void setPin(String pin) {
        this.pin = pin;
    }

    @JsonIgnore
    public String getPinValue() {
        return pin;
    }

}