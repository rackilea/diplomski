SortedMap<String, String>   map = new TreeMap<>(new Comparator<String>() {
   @Override
   public int compare(String o1, String o2) {
   if(o1.length()==o2.length()&&o1.contains("_")&&o1.contains("_"))
  {
       String temp1,temp2;
   temp1=o1.substring(o1.lastIndexOf("_"));
    temp2=o2.substring(o2.lastIndexOf("_"));
    return temp1.compareTo(temp2);
   }
   else  if(o1.length()>o2.length())
  {

    return 1;
   }
   else  if(o1.length()<o2.length())
  {

    return -1;
   }
    return o1.compareTo(o2);
   }
 });

 map.put("100_101","lll");
 map.put("100_102","lll");
 map.put("100_101_103","lll");
 map.put("100_101_104","lll");
 map.put("100","lll");

 System.out.println(map);