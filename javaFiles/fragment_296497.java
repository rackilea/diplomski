static int getDimensionality(final Class<?> type) {
    if (type.isArray()) {
        return 1 + getDimensionality(type.getComponentType());
    }
    return 0;
}

public static void main (String[] args) {
    System.out.println(getDimensionality(int.class));       // 0
    System.out.println(getDimensionality(int[].class));     // 1
    System.out.println(getDimensionality(int[][].class));   // 2
    System.out.println(getDimensionality(int[][][].class)); // 3
}