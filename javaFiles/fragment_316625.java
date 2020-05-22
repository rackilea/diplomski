Collections.sort(arraylist, new Comparator<HistoryBank>() {

        public int compare(HistoryBank s1, HistoryBank s2) {
            return Integer.valueOf(s2.getDate())
                    .compareTo(Integer.valueOf(s1.getDate()));
        }

   });