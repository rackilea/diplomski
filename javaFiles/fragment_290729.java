private static final Map<Classname, Classname> cache = new HashMap<Classname, Classname>();
public static Classname getClassName(Object o){
   Classname newC = new Classname(a, b, ...);
   Classname oldC = cache.get(newC);
   if ( oldC == null ) {
       cache.put(newC, newC);
       return newC;
   } else {
       return oldC;
   }
}