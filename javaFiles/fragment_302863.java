final Set<String> intersection;
final Set<String> values2;

// Since we're going to mutate the first set, we create a new set that is 
// completely independent from the map.  We fill it with they keys of the 
// first map.

intersection = new HashSet<String>(map1.keySet());  // get the first map's keys
values2 = map2.keySet();                            // ... and the second map's keys

intersection.retainAll(values2);                    // find the intersection

for (String key : intersection)                     // for each value in both sets ...
{                                                   // ... output the details
  System.out.println("key: " + key);
  System.out.println("value 1: " + map1.get(key));
  System.out.println("value 2: " + map2.get(key));
}