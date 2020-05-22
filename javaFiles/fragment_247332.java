TreeMap sortedItems = new TreeMap(items);

   // keySet returns the Map's keys, which will be sorted because it's a treemap.
   for(Object s: sortedItems.keySet()) {

       // Yeah, I hate this too.
       String k = (String) s;

       // but now we have the key to the map.

       // Now you can get the MailItems.  This is the part you were missing.
       List<MailItem> listOfMailItems = items.get(s);

       // Iterate over this list for the associated MailItems
       for(MailItem mailItem: listOfMailItems) {
          System.out.println(mailItem.getSomething());
          }
       }