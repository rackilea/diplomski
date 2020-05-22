import java.util.Comparator;

public class ComplexComparator implements Comparator<Student> {

    private Comparator<Student> comparatorOne;
    private Comparator<Student> comparatorTwo;

    public ComplexComparator(Comparator<Student> one,
            Comparator<Student> another) {
        this.comparatorOne = one;
        this.comparatorTwo = another;
    }

    @Override
    public int compare(Student one, Student another) {
        // make a first comparison using comparator one
        int comparisonByOne = comparatorOne.compare(one, another);

        // check if it was 0 (items equal in that attribute)
        if (comparisonByOne == 0) {
            // if yes, return the result of the next comparison
            return comparatorTwo.compare(one, another);
        } else {
            // otherwise return the result of the first comparison
            return comparisonByOne;
        }
    }
}