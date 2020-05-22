public <T extends A> T getItemByType(Class<T> c) {
   for(Object o : container){
      if(c.isInstance(o)){
         return c.cast(o);        
      }
   }
   return null;
}