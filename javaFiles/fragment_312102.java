int[] sorted = new int[n];
int h = 0;
for (int i = 0; i < count.length; i++) {
    for (int j = 0; j < count[i]; j++) {
        // Sum 1 to i to get the original number
        sorted[h++] = i + 1;
    }
}

System.out.println(Arrays.toString(sorted));