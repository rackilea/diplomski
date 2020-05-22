Comparator<Date> ymdComparator = new Comparator<Date>() {
        @Override public int compare(Date d1, Date d2) {
            return 
                d1.getYear() < d2.getYear() ? -1 :
                d1.getYear() > d2.getYear() ? +1 :
                d1.getMonth() < d2.getMonth() ? -1 :
                d1.getMonth() > d2.getMonth() ? +1 :
                d1.getDay() < d2.getDay() ? -1 :
                d1.getDay() > d2.getDay() ? +1 :
                0;
        }
    };

    SortedMap<Date,V> map = new TreeMap<Date,V>(ymdComparator);