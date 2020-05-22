package forum10511601;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="Example")
@XmlAccessorType(XmlAccessType.FIELD)
class Example {

    @XmlAttribute
    private String library;

    @XmlPath("book/AUTHORS_TEST/text()")
    private String authorsTest;

    @XmlPath("book/EXAMPLE_TEST/text()")
    private String exampleTest;

}