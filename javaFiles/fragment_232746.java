Map<Set<String>, Object> map  = new HashMap<Set<String>, Object>();

   Set<String> key1 = new HashSet<String>();
   key1.add( "hello");

   Set<String> key2 = new HashSet<String>();
   key2.add( "hello2");

   Set<String> key2clone = new HashSet<String>();
   key2clone.add( "hello2");

   map.put( key1, new Object() );
   map.put( key2, new Object() );

   System.out.println( map.containsKey(key1)); // true
   System.out.println( map.containsKey(key2)); // true
   System.out.println( map.containsKey(key2clone)); // true

   key2.add( "mutate" );

   System.out.println( map.containsKey(key1)); // true
   System.out.println( map.containsKey(key2)); // false
   System.out.println( map.containsKey(key2clone)); // false (*)

   key2.remove( "mutate" );

   System.out.println( map.containsKey(key1)); // true
   System.out.println( map.containsKey(key2)); // true
   System.out.println( map.containsKey(key2clone)); // true