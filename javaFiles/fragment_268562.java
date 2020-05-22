package forum14998000;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "entity")
public class Entity {

    @XmlPath("atom:link[@rel='first']")
    protected AtomLink first;

    @XmlPath("atom:link[@rel='second']")
    protected AtomLink second;

    public Entity() {
    }

    public Entity(AtomLink first, AtomLink second) {
        this.first = first;
    this.second = second;
    }

}