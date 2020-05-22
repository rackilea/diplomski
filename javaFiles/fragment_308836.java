package forum7673323;

import java.io.File;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Recon {

    @XmlAttribute
    private String outputPath;

    @XmlAttribute
    @XmlJavaTypeAdapter(FileAdapter.class)
    private File withCompareFile;

    @XmlAttribute
    @XmlJavaTypeAdapter(FileAdapter.class)
    private File toCompareFile;

    @XmlElement(name="sheet")
    private List<ReconSheet> reconSheets;

}