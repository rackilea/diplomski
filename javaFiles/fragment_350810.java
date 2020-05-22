public class MyClass<T extends Comparable<T>> {
    public T[] myAlgorithm( T[] list1, T[] list2 ) {
        @SuppressWarnings("unchecked")
        T[] newList = (T[])Array.newInstance(list1[0].getClass(), list1.length);

        for (T t1 : list1) {
            for (T t2 : list2) {
                if(t1.compareTo(t2)==0) {
                    //TODO
                }
            }
        }

        return newList;
    }
}