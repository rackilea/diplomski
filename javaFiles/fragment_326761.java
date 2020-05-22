import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Definitions {

    @XmlElement
    private Process process;

    public Definitions() {
    }

    public Definitions(Process process) {
        this.process = process;
    }

    public Process getProcess() {
        return process;
    }
}