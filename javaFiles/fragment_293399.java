// assume the key is in format of "ABCDE,12345", and you want to sort by the numeric part:
Map<String, Foo> oldMap = ....; // assume you populated something in it
Map<String, Foo> sortedMap 
    = new TreeMap((a,b) -> {
                     // here I use split(), you can use regex
                     int aNum = Integer.valueOf(a.split(",")[1]);
                     int bNum = Integer.valueOf(b.split(",")[1]);
                     if (aNum != bNum )  {
                         return aNum - bNum;
                     } else {
                         return a.compareTo(b);
                     });
sortedMap.addAll(oldMap);
// now sortedMap contains your entries in sorted order.
// you may construct a new LinkedHashMap with it or do whatever you want