Arrays.sort(table, new Comparator<String[]>() {
        @Override
        public int compare(final String[] entry1, final String[] entry2) {
            int n1 = Integer.parseInt(entry1[0]);
            int n2 = Integer.parseInt(entry2[0]);
            return n1 - n2;
        }
    });