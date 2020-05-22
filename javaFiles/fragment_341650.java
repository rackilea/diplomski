public class ArrayStringList implements StringList {

  private static final int INITIAL_CAPACITY = 10;

  private String[] stringArray;
  private int size;

  public ArrayStringList(StringList sl) {
    stringArray = sl.toArray();
    size = stringArray.length;
  }


  public ArrayStringList() {
    stringArray = new String[INITIAL_CAPACITY];
    size = 0;
  }

  // TODO: Extract 'if-cascade' to an validate(..) method 
  @Override
  public String set(int index, String s) {
    if (index >= size) {
      throw new IndexOutOfBoundsException("")
    } else if (s == null) {
      throw new NullPointerException("the specified string is null");
    } else if (s.isEmpty()) {
      throw new IllegalArgumentException("specified string is empty");
    }
    String old = stringArray[index];
    stringArray[index] = s;
    return old;
  }

  // TODO: Check if posible to extend the stringArray
  @Override
  public boolean add(String s) {
    if (s == null) {
      throw new NullPointerException("the specified string is null");
    } else if (s.isEmpty()) {
      throw new IllegalArgumentException("specified string is empty");
    }

    if (size == stringArray.length) {
      int newListCapacity = stringArray.length * 2;
      stringArray = Arrays.copyOf(stringArray, newListCapacity);
    }
    stringArray[++size] = s;
    return true;
  }

  // TODO: implement other methods ...
}