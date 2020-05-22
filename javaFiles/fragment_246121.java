Comparator<String> myComparator = new Comparator<String>() {

        @Override
        public int compare(String s1, String s2) {
            if (map.get(s1) < map.get(s2)) {
                return -1;
            } else if (map.get(s1) > map.get(s2)) {
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        }

    };