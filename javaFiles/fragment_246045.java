public static Object[] toArray(List list) {
    return toArray(list, Object.class);
}
public static <E> E[] toArray(List<? extends E> list, Class<E> eClass) {
    @SuppressWarnings("unchecked") 
    E[] array = (E[]) Array.newInstance(eClass, list.size());
    for (int i = 0; i < array.length;i++)
        array[i] = list.get(i);
    return array;
}