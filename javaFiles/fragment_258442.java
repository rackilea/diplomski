ClasWithStuff myStuff = new ClassWithStuff();
Field[] fields = myStuff.getClass().getDeclaredFields();
for(Field f : fields){
   Class t = f.getType();
   Object v = f.get(myStuff);
   if(t == boolean.class && Boolean.FALSE.equals(v)) 
     // found default value
   else if(t.isPrimitive() && ((Number) v).doubleValue() == 0)
     // found default value
   else if(!t.isPrimitive() && v == null)
     // found default value
}