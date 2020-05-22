SortedSet<Map.Entry<int, Obj>> sortedset = new TreeSet<Map.Entry<int, Obj>>(
            new Comparator<Map.Entry<int, Obj>>() 
         {

             public int compare(Entry<int, Obj> o1, Entry<int, Obj> o2)
             {
                 return o1.getValue().compareTo(o2.getValue());
            } 
         });