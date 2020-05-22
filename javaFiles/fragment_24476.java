public static int solveBullshitTaskInASmartWay(int n) {
    // get characters and sort them
    char[] chars = Integer.toString(n).toCharArray();
    Arrays.sort(chars);
    // comparators don't work in Java for primitives,
    // so you either have to flip the array yourself
    // or make an array of Integer or Character
    // so that Arrays.sort(T[] a, Comparator<? super T> c)
    // can be applied
    for (int i = 0, j = chars.length - 1; i < j; i++, j--) {                                                                                   
        char t = chars[i]; chars[i] = chars[j]; chars[j] = t;
    }
    // reconstruct the number
    return Integer.parseInt(new String(chars));
}