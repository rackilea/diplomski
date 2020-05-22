interface Serializer<T> { }
public static <N,V> void createColumn (N name, V value, Serializer<N> nameSerializer, Serializer<V> valueSerializer) {
}

public static void main(String[] args) throws  NoSuchFieldException {
    Object object1 = "hi";
    Object object2 = 31;
    Serializer<String> serializer1 = null;
    Serializer<Integer> serializer2 = null;
    createColumn(object1, object2, (Serializer) serializer1, (Serializer) serializer2);
}