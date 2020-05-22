public class QualifierAdapter extends XmlAdapter<String, Qualifier> {

   public String marshal(Qualifier qualifier) {
      return qualifier.getCode();
   }

   public Qualifier unmarshal(String val) {
      return Qualifier.getFromCode(val);   // I assume you have a way of doing this
   }
}