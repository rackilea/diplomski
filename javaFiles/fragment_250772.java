Integer[] array = new Integer[] { 1, 2, 1, 1, 1, 3, 3, 3, 2, 2, 4, 5 };

for (int i = 0; i < array.length; i++) {
    int count = 0;
    if (array[i] != null) {
        int compare = array[i].intValue();
        for (int j = 0; j < array.length; j++) {

            if (array[j] != null) {
                if (compare == array[j]) {
                    array[j] = null;
                    count++;
                }
            }

        }
        if (count >= 3) {
            System.out
                    .println(compare + " exists " + count + " times.");
        }
    }
}