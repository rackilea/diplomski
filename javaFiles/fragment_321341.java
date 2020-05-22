public Object methodAssign(Object object, HashMap<String, Object> fields) {
   for(Entry<String, Object> entry : fields.entrySet()) {
     if(BeanUtils.getProperty(object, entry.getKey()) == null)
         BeanUtils.setProperty(object, entry.getKey(), entry.getValue());
   }
   return object;
}