import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlReadTransformer;
import org.eclipse.persistence.oxm.annotations.XmlTransformation;
import org.eclipse.persistence.oxm.annotations.XmlWriteTransformer;
import org.eclipse.persistence.oxm.annotations.XmlWriteTransformers;

@XmlAccessorType(XmlAccessType.FIELD)
public class ElemB {

    @XmlTransformation
    @XmlReadTransformer(transformerClass=DateAttributeTransformer.class)
    @XmlWriteTransformers({
        @XmlWriteTransformer(xpath="B_DATE/text()", transformerClass=DateFieldTransformer.class),
        @XmlWriteTransformer(xpath="B_TIME/text()", transformerClass=TimeFieldTransformer.class),
    })
    private Date bDate;

    @XmlElement(name="NUM")
    private int num;

    @XmlTransformation
    @XmlReadTransformer(transformerClass=DateAttributeTransformer.class)
    @XmlWriteTransformers({
        @XmlWriteTransformer(xpath="C_DATE/text()", transformerClass=DateFieldTransformer.class),
        @XmlWriteTransformer(xpath="C_TIME/text()", transformerClass=TimeFieldTransformer.class),
    })
    private Date cDate;

}