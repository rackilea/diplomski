package forum987537;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({Account.class, Opportunity.class})
public abstract class SObject {
  public abstract String getId();
  public abstract void setId(String id);
}