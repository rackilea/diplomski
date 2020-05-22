PropertyFilter pf = new PropertyFilter(){  
   public boolean apply( Object source, String name, Object value ) {  
      if( value != null && Number.class.isAssignableFrom( value.getClass() ) ){  
         return true;  
      }  
      return false;  
   }  
};

PrimitiveBean bean = new PrimitiveBean();  
JsonConfig jsonConfig = new JsonConfig();  
jsonConfig.setJsonPropertyFilter(pf); 
JSONObject json = JSONObject.fromObject( bean, jsonConfig );