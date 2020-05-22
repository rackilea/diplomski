@SuppressWarnings("unchecked")
public E[] getNodes(E[] a) {
    int size = nodes.size();
    // creates an empty array of the right size and type
    E[] arr =(E[]) java.lang.reflect.Array
            .newInstance(a.getClass().getComponentType(), size);
    // fills that array with the correct data
    for (int i = 0; i < size; i++)
        arr[i] = nodes.get(i).getObject();
    return arr;
}