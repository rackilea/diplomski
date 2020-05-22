import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class ByteArrayWithOverloadedSetterObject {

    private byte[] data;

    @JsonProperty //I ADDED THIS
    public void setData(byte[] data) {
        this.data = data;
    }

    @XmlTransient
    @JsonIgnore
    public void setData(String data) {
        this.data = data.getBytes();
    }

    public byte[] getData() {
        return data;
    }
}