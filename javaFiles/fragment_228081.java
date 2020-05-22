Collections.sort(list, new Comparator<String>()
  {
     int compare(String o1, String o2)
     {
         if (o1.equals(o2)) // update to make it stable
           return 0;
         if (o1.equals("general"))
           return -1;
         if (o2.equals("general"))
           return 1;
         return o1.compareTo(o2);
     }
});