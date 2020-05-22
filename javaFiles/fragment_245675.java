public class DynamicStringArray {
    private static final int CAPACITY_INCREMENT = 10;
    private static final int INITIAL_CAPACITY = 10;

    private final int capacityIncrement;

    public int length = 0;
    public String[] array;

    public DynamicStringArray(int initialCapacity, int capacityIncrement) {
        this.capacityIncrement = capacityIncrement;
        this.array = new String[initialCapacity];
    }

    public DynamicStringArray() {
        this(CAPACITY_INCREMENT, INITIAL_CAPACITY);
    }

    public int append(String str) {
        final int offset = length;
        if (offset == array.length) {
            String[] old = array;
            array = new String[offset + capacityIncrement];
            System.arraycopy(old, 0, array, 0, offset);
        }
        array[length++] = str;
        return offset;
    }

    public void removeElementAt(int offset) {
        if (offset >= length) {
            throw new ArrayIndexOutOfBoundsException("offset too big");
        }

        if (offset < length) {
            System.arraycopy(array, offset + 1, array, offset, length - offset
                    - 1);
            length--;
        }
    }
}