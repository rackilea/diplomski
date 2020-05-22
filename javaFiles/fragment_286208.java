package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
class IdDetails {

    @XmlElement(name="SLNO")
    private int SLNO;

    @XmlElement(name="SOURCE_ID")
    private String SOURCE_ID;

    @XmlElement(name="ID_VALUE")
    private int ID_VALUE;

    @XmlElement(name="EXP_DATE")
    private String EXP_DATE;

    public IdDetails(){}

    public int getSLNO() {
        return SLNO;
    }

    public void setSLNO(int SLNO) {
        this.SLNO = SLNO;
    }

    public String getSOURCE_ID() {
        return SOURCE_ID;
    }

    public void setSOURCE_ID(String SOURCE_ID) {
        this.SOURCE_ID = SOURCE_ID;
    }

    public int getID_VALUE() {
        return ID_VALUE;
    }

    public void setID_VALUE(int ID_VALUE) {
        this.ID_VALUE = ID_VALUE;
    }

    public String getEXP_DATE() {
        return EXP_DATE;
    }

    public void setEXP_DATE(String EXP_DATE) {
        this.EXP_DATE = EXP_DATE;
    }
}