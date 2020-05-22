import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TEST_REQ", namespace = "http://Test.com")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ResponseKeysBean {

    private Keys keyList;
    private Root status;

    public ResponseKeysBean() {
        // TODO Auto-generated constructor stub
    }

    @XmlElement(name="keys")
    public Keys getKeyList() {
        return keyList;
    }

    public void setKeyList(Keys keyList) {
        this.keyList = keyList;
    }

    @XmlElement(name="root")
    public Root getStatus() {
        return status;
    }

    public void setStatus(Root status) {
        this.status = status;
    }
}  

class Root {
    private String messageId;
    private Integer statusCode;
    private String statusMessage;

    @XmlElement(name="messageid")
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @XmlElement(name="statuscode")
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @XmlElement(name="statusmessage")
    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "Root [messageId=" + messageId + ", statusCode=" + statusCode
                + ", statusMessage=" + statusMessage + "]";
    }


}

class Keys {
    private List<Item> keysList;

    public Keys() {
        // TODO Auto-generated constructor stub
    }

    @XmlElement(name="item")
    public List<Item> getKeysList() {
        return keysList;
    }

    public void setKeysList(List<Item> keysList) {
        this.keysList = keysList;
    }

    @Override
    public String toString() {
        return "Keys [keysList=" + keysList + "]";
    }   
}

class Item {

    private String key;

    @XmlElement(name="key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Item [key=" + key + "]";
    }
}