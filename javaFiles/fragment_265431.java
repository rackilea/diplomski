import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCustomizer;

@XmlRootElement(name="RootEntity")
@XmlCustomizer(RootEntityCustomizer.class)
public class RootEntity {

    private String attributeOne;
    private Entity entityOne;
    private Entity entityTwo;

    @XmlElement(name="AttributeOne")
    public String getAttributeOne() {
        return attributeOne;
    }

    public void setAttributeOne(String attributeOne) {
        this.attributeOne = attributeOne;
    }

    @XmlElement(name="EntityOne")
    public Entity getEntityOne() {
        return entityOne;
    }

    public void setEntityOne(Entity entityOne) {
        this.entityOne = entityOne;
    }

    @XmlElement(name="EntityTwo")
    public Entity getEntityTwo() {
        return entityTwo;
    }

    public void setEntityTwo(Entity entityTwo) {
        this.entityTwo = entityTwo;
    }

}