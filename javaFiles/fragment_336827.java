@XmlType(name = "SequenceType")
public class Sequence {

    private String md5;
    private String sequence;

    @XmlAttribute
    public String getMd5() {
        return md5;
    }

    @XmlValue
    public String getSequence() {
        return sequence;
    }

}