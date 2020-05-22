import java.util.Arrays;

/*
 * Definition of the class that also includes the declaration
 * of the implementation of the Cloneable interface.
 */
public class Gene implements Cloneable {

    /*
     * The length of a gene.
     * It is defined as constant (final) in order to use the same value
     * in the whole class, where and when necessary.
     */
    private static final int GENE_LENGTH = 4;

    /*
     * In biology a gene it corresponds to a sequence of nucleic acids,
     * so I thought of naming m_sequence this field.
     */
    private char m_sequence[];

    /*
     * This constructor allows you to instantiate a new object from a char array.
     */
    public Gene(char sequence[]) {
        // The field m_sequence is initialized with a copy
        // of the array specified in the constructor.
        m_sequence = Arrays.copyOf(sequence, GENE_LENGTH);
    }

    /*
     * Simple getter method.
     * Since m_sequence is private, you need a method like this
     * in order to access elements of the array.
     */
    public char getUnit(int index) {
        return m_sequence[index];
    }

    /*
     * Simple setter method.
     * Since m_sequence is private, you need a method like this
     * in order to set the elements of the array.
     */
    public void setUnit(int index, char unit) {
        m_sequence[index] = unit;
    }

    /*
     * The Cloneable declaration requires that this class has clone method.
     * This method should return an Gene object within an Object.
     */
    protected Object clone() throws CloneNotSupportedException {
        // First, we invoke the clone method of the superclass
        Gene clone = (Gene)(super.clone());

        // Then, make the deep copy of the object.
        // In this case the only field present in the Gene object is an array,
        // then you must make a deep copy of this array: in order to make a deep
        // copy of the array, you should use the Arrays.copyOf method.
        clone.m_sequence = Arrays.copyOf(m_sequence, GENE_LENGTH);

        return clone;
    }

    /*
     * Get a representation of this object as a String.
     * Just a method for simple testing.
     */
    @Override
    public String toString() {
        return Arrays.toString(m_sequence);
    }
}