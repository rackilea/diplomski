package forum13884782;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

@XmlRootElement(name="bean")
@XmlDiscriminatorNode("@class")
public class ObjectMap {

}