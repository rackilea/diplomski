package forum13884782;

import javax.xml.bind.annotation.*;

import org.eclipse.persistence.oxm.annotations.*;

@XmlRootElement(name="bean")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlDiscriminatorValue("AddressMap")
public class AddressMap extends ObjectMap {

    @XmlPath("property[@name='PropName']/@value")
    String prop;

    @XmlPath("property[@name='PropName1']/@value")
    String prop1;

    @XmlPath("property[@name='PropName2']/@value")
    String prop2;

    @XmlPath("property[@name='PropName3']/@value")
    String prop3;

    @XmlPath("property[@name='PropName4']/@value")
    String prop4;

    @XmlPath("property[@name='PropName5']/@value")
    String prop5;

    @XmlPath("property[@name='PropName6']/@value")
    String prop6;

}