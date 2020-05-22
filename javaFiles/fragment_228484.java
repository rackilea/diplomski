int[] array = {6, 4, 3, 2};
// TextView tv = (TextView) findViewById(R.id.textView2);
// Resets the text to be blank.
// tv.setText("");

for (int i = 1; i < array.length; ++i) {
    int j = i;
    while (j > 0 && array[j - 1] > array[j]) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
        --j;
    }
    System.out.println(Arrays.toString(array));
    // i.e. [4, 6, 3, 2]
    // tv.append(Arrays.toString(array) + "\n");
}