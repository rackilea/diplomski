public class RequestParams {

    @XmlElement(name = "my-val-1" )
    @JsonProperty(value = "my-val-1")
    private String myVal1;

    @XmlElement(name = "my-val-2")
    @JsonProperty(value = "my-val-2")
    private String myVal2;

    public RequestParams() {
    }

    public String getMyVal1() {
        return myVal1;
    }

    public void setMyVal1(String myVal1) {
        this.myVal1 = myVal1;
    }

    public String getMyVal2() {
        return myVal2;
    }

    public void setMyVal2(String myVal2) {
        this.myVal2 = myVal2;
    }
}