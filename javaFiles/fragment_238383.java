public void myApiNoSupportForNull(Collection<Object> collection){
   // Pre condition
   if(collection == null) 
     throw new IllegalArgumentException("This API does not support null collections!");
   //...
}