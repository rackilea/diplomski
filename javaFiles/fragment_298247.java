import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MeetUpData implements Serializable {

    private static final long serialVersionUID = 1L;
    String location;
    String name;
    List<SessionData> sessionsData;

    public MeetUpData() {
        super();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SessionData> getSessionsData() {
        return sessionsData;
    }

    public void setSessionsData(List<SessionData> sessionsData) {
        this.sessionsData = sessionsData;
    }

    @Override
    public String toString() {
        return "MeetUpData [location=" + location + ", name=" + name + ", sessionData=" + sessionsData + "]";
    }

}