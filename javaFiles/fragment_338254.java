@XmlRootElement(name = "Fault")
public class Fault {
    private String message;
    @XmlElement(name = "Message")
    public String getMessage() {
        return message;
    } 
    public void setMessage(String message) {
        this.message = message;
    }
}