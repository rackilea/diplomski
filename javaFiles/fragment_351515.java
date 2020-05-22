Object o =
for (Field field : o.getClass().getDeclaredFields()) {
 Class t = field.getType();
 Object v = field.get(o);
 if(t == boolean.class && Boolean.FALSE.equals(v)) 
   // found default value
 else if(t == char.class && ((Character) v).charValue() == 0)
   // found default value
 else if(t.isPrimitive() && ((Number) v).doubleValue() == 0)
   // found default value
 else if(v == null)
   // found default value
}