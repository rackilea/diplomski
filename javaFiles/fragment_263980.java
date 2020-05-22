package message;   

import javax.xml.bind.annotation.*;   

@XmlRootElement@XmlAccessorType(XmlAccessType.FIELD) 
public class Message {
    @XmlAttribute
    private String to;       

    @XmlAttribute    
    private String from;       

    @XmlAnyElement    
    private Object body;   
}