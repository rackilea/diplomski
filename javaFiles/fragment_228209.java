public class ArrayListOfIntegers extends ArrayList<Integer> {}

...

// writing:
ArrayListOfIntegers ouList = new ArrayListOfIntegers();
...
// reading:
ArrayListOfIntegers inList;
Object readData = in.readObject();
if (readData instanceof ArrayListOfIntegers) {
    inList = (ArrayListOfIntegers) readData;
} else {
    throw new RuntimeException("...");
}