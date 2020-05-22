MyObject findIfPresent(MyObject source, HashSet<MyObject> set)
{
   if (set.contains(source)) {
      for (MyObject obj : set) {
        if (obj.equals(source)) 
          return obj;
      } 
   }

  return null;
}