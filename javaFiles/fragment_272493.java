@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Job {

    private int id;
    private String type;
    private String user;
    private String device;
    private int amount;

    @XmlElement
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @XmlElement
    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    @XmlElement
    public String getUser(){
        return user;
    }

    public void setUser(String iser){
        this.user = user;
    }

    @XmlElement
    public String getDevice(){
        return device;
    }

    public void setDevice(String device){
        this.device = device;
    }

    @XmlElement
    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

}