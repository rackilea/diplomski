char[] array = new char[4]; //Array looks like [A, A, B, C]

for(int i = array.length - 1; i > 0; i--) {
    array[i] = array[i - 1];
}
array[0] = 'D';