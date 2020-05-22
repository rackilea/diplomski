package forum7534500;

import java.util.Hashtable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Wrapper {

    private Hashtable<String, String> hashtable;

    public Hashtable<String, String> getHashtable() {
        return hashtable;
    }

    public void setHashtable(Hashtable<String, String> hashtable) {
        this.hashtable = hashtable;
    }

}