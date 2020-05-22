// assume array[i] is within range [0, 46341) for any i
static void f(int[] array) {
    for (int i = 0; i < array.length; i++) {
        int j = array[i] & 0xffff; // get old value
        array[i] = array[j] << 16 | j; // put new and old values
    }
    for (int i = 0; i < array.length; i++) {
        int j = array[i] >>> 16; // get new value
        array[i] = j * j; // put new value squared
    }
}