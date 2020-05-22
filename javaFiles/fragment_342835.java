class MyObjectCache
{
     ....
     void registerObject(Object o)
     {
         if (objects.contains(o))
         {
             return;
         }

         objects.add(o);
         for(Field field : o.getClass().getDeclaredFields())
         {
             field.setAccessible(true);
             registerObject(field.get(o));
         }
    }
    ...
}