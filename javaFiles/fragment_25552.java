class Item{
   private String itemName; // I assume all items will have a name.
   private Map<ItemAttibuteName , Object> attributeMap ; // this will be a dynamic map.

   public Map<ItemAttibuteName, Object> getAttributeMap(){//getter for attribute map
       if( null == attributeMap)
          return new HashMap<String, Object>(); 
       return attributeMap ;

   }
   // you can synchronize this if needed
   public void setAttribute(ItemAttibuteName name, Object value){ 
       attributeMap.put(name, value);
   }

   public Object getAttribute(ItemAttibuteName name){ 
       return attributeMap.get(name);
   }
}

public enum ItemAttibuteName{
    SIZE,
    COLOUR        
}