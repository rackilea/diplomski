Arrays.sort(data1, new Comparator<Object[]>() {

            @Override
            public int compare(final Object[] entry1, final Object[] entry2) {
                final Integer time1 = Integer.parseInt(entry1[1].toString());
                final Integer time2 = Integer.parseInt(entry2[1].toString());
                return time2.compareTo(time1);
            }
        });