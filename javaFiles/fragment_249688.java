Collections.sort(myStringList, new Comparator()
                               {
                                   public int compareTo(String a, String b)
                                   {
                                       return a.compareTo(b) * -1; 
                                   }
                               }
               );