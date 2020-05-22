Random random = new Random();
    int[] perm = new int[10];
    for (int i = 0; i < 10; i++) {
        perm[i] = i;
    }
    for (int i = 0; i < 9; i++) {
        int j = random.nextInt(10 - i);
        int tmp = perm[i];
        perm[i] = perm[i + j];
        perm[i + j] = tmp;
    }
    System.out.println(Arrays.toString(perm));