final Object[][] data1 = datanew;
    Arrays.sort(data1, new Comparator<Object[]>() {

        @Override
        public int compare(final Object[] entry1, final Object[] entry2) {
            final String time1 = entry1[2].toString();
            final String time2 = entry2[2].toString();
            return time2.compareTo(time1);
        }
    });