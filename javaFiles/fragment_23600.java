public class ComplexComparator implements Comparator<Student> {

    private Comparator<Student> comparatorOne;
    private Comparator<Student> comparatorTwo;
    private boolean orderOneAscending = true;
    private boolean orderTwoAscending = true;

    /**
     * Constructor without any sort orders
     * @param one   a comparator
     * @param another   another comparator
     */
    public ComplexComparator(Comparator<Student> one, Comparator<Student> another) {
        this.comparatorOne = one;
        this.comparatorTwo = another;
    }

    /**
     * Constructor that provides the possibility of setting sort orders 
     * @param one   a comparator
     * @param orderOneAscending sort order for comparator one 
     *      (true = ascending, false = descending)
     * @param another   another comparator
     * @param orderTwoAscending sort order for comparator two
     *      (true = ascending, false = descending)
     */
    public ComplexComparator(Comparator<Student> one, boolean orderOneAscending,
            Comparator<Student> another, boolean orderTwoAscending) {
        this.comparatorOne = one;
        this.comparatorTwo = another;
        this.orderOneAscending = orderOneAscending;
        this.orderTwoAscending = orderTwoAscending;
    }

    @Override
    public int compare(Student one, Student another) {
        int comparisonByOne;
        int comparisonByAnother;

        if (orderOneAscending) {
            /*  note that your lexicographical comparison in NameComparator 
                returns a negative integer if the String is greater!
                If you take two numerical Comparators, the order will
                turn into the opposite direction! */
            comparisonByOne = comparatorOne.compare(another, one);
        } else {
            comparisonByOne = comparatorOne.compare(one, another);
        }

        if (orderTwoAscending) {
            comparisonByAnother = comparatorTwo.compare(one, another);
        } else {
            comparisonByAnother = comparatorTwo.compare(another, one);
        }

        if (comparisonByOne == 0) {
            return comparisonByAnother;
        } else {
            return comparisonByOne;
        }
    }
}