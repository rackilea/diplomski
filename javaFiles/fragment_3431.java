Comparator<String> customComparator = new Comparator<String>() {
        @Override public int compare(String s1, String s2) {
            // Add null check
            if(s1.equals("Orange"))
               return 1; 
            else if(s2.equals("Orange"))
               return -1;
            return s1.compareTo(s2);
        }           
    };