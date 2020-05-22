@SuppressWarnings("unchecked")
public static <T> T[][] toTwoDim(T[] array) {
    Class<T> ctype = (Class<T>) array.getClass().getComponentType();
    int halfLength = array.length / 2;
    T[][] ret = (T[][]) Array.newInstance(ctype, 2, 1);
    T[] r1 = (T[]) Array.newInstance(ctype, halfLength);
    T[] r2 = (T[]) Array.newInstance(ctype, array.length - halfLength);
    ret[0] = r1;
    ret[1] = r2;
    for (int i = 0; i < halfLength; i++)
        r1[i] = array[i];
    for (int i = 0; i < array.length - halfLength; i++) {
        r2[i] = array[i + halfLength];
    }
    return ret;
}

public static void main(String[] a) {
    Integer[] bar = { 1, 2, 3, 4, 5 };
    Integer[][] dims = toTwoDim(bar);
    for (Integer[] r : dims) {
        for (Integer d : r) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}