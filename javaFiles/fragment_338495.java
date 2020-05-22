public class MyArrayList implements MyList {
    private Object[] theList;

    public MyArrayList(Object type) {
        // Adjust as you like
        int size = 0;
        // Dynamically create array of type "type"
        theList = (Object[]) Array.newInstance(type.getClass(), size);
    }
}