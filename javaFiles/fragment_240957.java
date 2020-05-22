import java.util.*;
class Merger {
    // break out total length logic. Will probably be inlined, but this seems like
    // functionality that deserves its own method.
    public static <T> int totalLength(T[]... arrays) {
        int length = 0;
        for(T[] arr : arrays) length += arr.length;
        return length;
    }

    public static <T> T[] merge(T[]... arrays) {
        int length = totalLength(arrays);
        if(length == 0) return (T[])new Object[0];
        List<T> list = new ArrayList<T>(length);
        for(T[] array : arrays) {
            for(T t : array) {
                list.add(t);
            }
        }
        return (T[])(list.toArray(arrays[0])); 
    }

    public static void main(String[] args) {
        String[] first = new String[] { "This", "is", "a", "test" };
        String[] second = new String[] { "of", "the", "merger" };
        String[] third = new String[] { "and", "it", "works!" };

        String[] merged = merge(first,second,third);
        for(String s : merged) System.out.println(s);

        // validate that it works for merging all 0 arrays:
        merge();
    }
}