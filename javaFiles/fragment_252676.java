LinkedHashMap<String, Integer> ht = new LinkedHashMap<String, Integer>();
 int value=0;
     for(int i=0; i<str.length()-1; i++) {
         ht.put(str.substring(i, i+2), value);
         value++;
     }
     Set<String> set = ht.keySet();
     Iterator<String> itr = set.iterator();
     while(itr.hasNext()) {
         String d = itr.next();
         System.out.println(d+ " "+ ht.get(d));
     }
    }