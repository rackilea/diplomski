Comparator<Entry<String, String>> valueComparator = new 
                                  Comparator<Entry<String,String>>() { 
  @Override public int compare(Entry<String, String> e1, Entry<String, 
     String> e2) { 

     String v1 = e1.getValue(); String v2 = e2.getValue(); return 
     v1.compareTo(v2); 
 } 
};