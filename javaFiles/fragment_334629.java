@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendSmsResponse", propOrder = {
    "result"
})
public class SendSmsResponse {
    @XmlElement(required = true,namespace="http://www.csapi.org/schema/parlayx/sms/send/v2_2/local")
    protected String result;
    public String getResult() {
        return result;
    }
    public void setResult(String value) {
        this.result = value;
    }

}