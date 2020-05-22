String[] words = new String[arr.length];
    int[] counts = new int[arr.length];
    words[0] = words[0];
    counts[0] = 1;
    for (int i = 1, j = 0; i < arr.length; i++) {
        if (words[j].equals(arr[i])) {
            counts[j]++;
        } else {
            j++;
            words[j] = arr[i];
            counts[j] = 1;
        }
    }