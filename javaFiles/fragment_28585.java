// from int[] to Integer[]
int[] source = ...
Integer[] target = new Integer[source.length];

for (int i = 0; i < source.length; i++) {
    // Convert int to Integer
    target[i] = Integer.valueOf(source[i]);
}

// from Integer[] to int[]
Integer[] source = ...
int[] target = new int[source.length];

for (int i = 0; i < source.length; i++) {
    if (source[i] == null) {
        // Don't support null values
        throw IllegalArgumentException();
    }

    // Convert Integer to int
    target[i] = source[i].intValue();
}