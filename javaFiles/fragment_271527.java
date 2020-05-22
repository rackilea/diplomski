Set<String> set = new HashSet<String>();
Set<String> set3 = new HashSet<String>(); // A different set object
Set<String> set2 = set;   // Point to the same set object as "set"

set2.clear();  // Will clear the actual object. Pointed by "set"
// And thus both the reference pointing to that object, will see the change.

set3 = set; // Change reference `set3` to point to the `Set object` pointed by `set`

set3.add("a");  // Will change `set` also.