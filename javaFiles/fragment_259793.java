Integer[] array = {1,2,3};
array = expand(array, 10);
System.out.println(array.length);

public <T> T[] expand(T[] array, int number) {
    array = java.util.Arrays.copyOf(array, array.length + number);
    return array;
}