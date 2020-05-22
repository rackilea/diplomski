import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlReadTransformer;
import org.eclipse.persistence.oxm.annotations.XmlTransformation;
import org.eclipse.persistence.oxm.annotations.XmlWriteTransformer;
import org.eclipse.persistence.oxm.annotations.XmlWriteTransformers;

@XmlAccessorType(XmlAccessType.FIELD)
public class ElemA {

    @XmlTransformation
    @XmlReadTransformer(transformerClass=DateAttributeTransformer.class)
    @XmlWriteTransformers({
        @XmlWriteTransformer(xpath="A_DATE/text()", transformerClass=DateFieldTransformer.class),
        @XmlWriteTransformer(xpath="A_TIME/text()", transformerClass=TimeFieldTransformer.class),
    })
    public Date aDate;

    @XmlElement(name="STRING")
    private String string;
}