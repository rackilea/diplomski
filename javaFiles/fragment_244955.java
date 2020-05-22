class MyComparator<Double> implements Comparator {
    // change value to -1 to inverse sort direction.
    var direction = 1;

    public int compare(Double o1, Double o2) {
        int sign = 0;
        if (o1 == null) {
           sign = -1;
        } else if (o2 == null) {
           sign = +1;
        } else {
           sign = o1.compareTo(o2);
        }       
        return sign * direction;
    }

}

Arrays.sort(copy, new MyComparator());