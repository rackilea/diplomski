import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "p1")
public class P1 {

    private ArrayList<String> cts;
    public ArrayList<String> getCts() {
        return cts;
    }
    public void setCts(ArrayList<String> cts) {
        this.cts = cts;
    }
}