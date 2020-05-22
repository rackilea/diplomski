class Prop{
   public enum Properties {
       Name,
       Address,
       City
   }

   Map<Properties, String> propertyMap;

   public Prop() {
       this.propertyMap = new HashMap<Properties, String>();
   }


   public void String setValue(Properties prop, String value){
      this.propertyMap.put(prop, value);
   }

   public void String getValue(Properties prop){          
           return this.propertyMap(prop);
   }
}