public static int[] createArray(int size)
{
    int[] array = new int[size];
    int half = (size / 2) + (size % 2);
    int index = half;
    int value = 0;
    for (int i = 0; i < size; i++) {
        if (i == index) {
            half = (half / 2) + (half % 2);
            index += half;
            value++;
        }
        array[i] = value;
    }
    return array;
}