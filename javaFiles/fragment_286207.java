package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
class ConsumerDetails {

    @XmlElement(name="NAME")
    private String NAME;

    @XmlElement(name="DATE_OF_BIRTH")
    private String DATE_OF_BIRTH;

    @XmlElement(name="GENDER")
    private String GENDER;

    private String NATIONALITY;

    public ConsumerDetails(){}

    public String getNAME() {
        return NAME;
    }
    public void setNAME(String nAME) {
        NAME = nAME;
    }
    public String getDATE_OF_BIRTH() {
        return DATE_OF_BIRTH;
    }
    public void setDATE_OF_BIRTH(String dATE_OF_BIRTH) {
        DATE_OF_BIRTH = dATE_OF_BIRTH;
    }
    public String getGENDER() {
        return GENDER;
    }
    public void setGENDER(String gENDER) {
        GENDER = gENDER;
    }
    public String getNATIONALITY() {
        return NATIONALITY;
    }
    public void setNATIONALITY(String nATIONALITY) {
        NATIONALITY = nATIONALITY;
    }
}