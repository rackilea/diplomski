public class ElementWithAttr {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "id")
        protected BigInteger id;  
   // ...  
    }  
    public class SomeName {

       @XmlElement(required = true)
       protected String title;
       @XmlElement(required = true)
       protected String time;
       @XmlElement(required = true)
       protected String date;
       protected List<ElementWithAttr> imgurl;
       protected List<ElementWithAttr> imgcap;  
   // ...  
   }