int[] counts = new int[MAX_NUM+1];
for (int a : a1) counts[a]++;
for (int a : a2) counts[a]++;
for (int a : a3) counts[a]++;
for (int i = 0 ; i != MAX_NUM+1 ; i++) {
    if (counts[i] > 1) {
        System.out.println(i);
    }
}