public class XmlGlobal {
   @XStreamConverter(value=NamedCollectionConverter.class, useImplicitType=false,
      strings={"attribute"}, types={XmlTargetExcludedAttribute.class})
   public List<XmlTargetExcludedAttribute> excluded;
}

public class XmlTargetExcludedAttribute {
   /** name attribute of class node */
   @XStreamAsAttribute
   public String name;
}


public class XmlAttribute {

   /** list of target attributes */
   @XStreamConverter(value=NamedCollectionConverter.class, useImplicitType=false,
      strings={"attribute"}, types={XmlTargetAttribute.class})
   public List<XmlTargetAttribute> attributes;
}

public class XmlTargetAttribute {

   /** name attribute of attribute node */
   @XStreamAsAttribute
   public String name;
}