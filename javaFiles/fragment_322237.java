import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

    @XmlElement(name="input-location")
    private String inputLocation;

    @XmlElement(name="output-location")
    private String outputLocation;

    @XmlElement(name="bit-rate")
    private int bitRate;

    @XmlElement(name="output-width")
    private int outputWidth;

    @XmlElement(name="output-height")
    private int outputHeight;

    @XmlElement(name="target-device")
    private String targetDevice;

}