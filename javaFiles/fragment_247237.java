@XmlRootElement(name = "Instance")
 public class Instance { 

    private List<Userdata> userdata;  
    @XmlElement(name = "Userdata") 
    public List<Userdata> getUserdata() {
     return userdata;
    }
  }