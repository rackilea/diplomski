class Prop{
   Map<String, String> propertyMap;

   public Prop() {
       this.propertyMap = new HashMap<String, String>();
   }


   public void String setValue(String prop, String value){
      this.propertyMap.put(prop, value);
   }

   public void String getValue(String prop){
      return this.propertyMap(prop);      
   }
}