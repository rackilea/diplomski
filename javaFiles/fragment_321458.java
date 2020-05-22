package forum14778338;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private IdentifierType identifierType;

    public IdentifierType getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(IdentifierType identifierType) {
        this.identifierType = identifierType;
    }

}