for (int i = 0; i < array.length; i++) {
    int count = 0;
    for (int j = 0; j < array.length; j++) {
        {
            if (array[i] == array[j]) {
                count++;
            }

        }
        if (count >= 3) {
            System.out.println(array[i] + " exists " + count
                    + " times.");
        }
    }
}