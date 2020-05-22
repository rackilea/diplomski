class TimeSorterByYearMonthDate implements Comparator<Time>{
    int compare(Time o1,Time o2) {
         if (o1.getYear() != o2.getYear() ) return o1.getYear().compareTo(o2.getYear());
         if (o1.getMonth() != o2.getMonth() ) return o1.getMonth().compareTo(o2.getMonth());
         return o1.getDate().compareTo(o2.getDate());
    }
}