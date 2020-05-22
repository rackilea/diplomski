You can use this code  as well to compare the string  as it is simple to compare string :

Collections.sort(list, new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }
    });