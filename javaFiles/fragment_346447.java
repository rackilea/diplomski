private static Comparator<DataBag> getComparator() {
        return new Comparator<DataBag>() {
           @Override
           public int compare(DataBag o1, DataBag o2) {
               String name = o1.getName();
               String name2 = o2.getName();

               // ordering is the natural String ordering in your example
               return name.compareTo(name2); 
           }
    };
}