Collections.sort(l1, new Comparator<customclas>() {
            @Override
            public int compare(customclas o1, customclas o2) {
                if (o1.a < o2.a) return -1;
                else if (o1.a > o2.a) return 1;
                else return 0;
            }
        });