package forum13646211;

import javax.xml.bind.annotation.XmlElement;

public class Root {

    private int[] testArrayInt;

    @XmlElement(type=Integer.class)
    public int [] getTestArrayInt () {
        return testArrayInt;
    }

    public void setTestArrayInt(int[] array) {
        this.testArrayInt = array;
    }

}