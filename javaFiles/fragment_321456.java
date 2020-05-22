private final Object[] objects= new Object[5];
private int clock = 0;

public Object getOrCache(Object obj) {
   for(Object o: objects) 
       if (obj.equals(o))
           return obj;
   objects[clock++ % objects.length] = obj;
   return obj;
}