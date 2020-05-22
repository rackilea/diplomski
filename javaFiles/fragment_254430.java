public static int arraySum(Object obj) {
    if (obj.getClass() == Integer.class)
        return ((Integer) obj).intValue();

    int sum = 0;
    for (Object o : (Object[]) obj)
        sum += arraySum(o);

    return sum;
}