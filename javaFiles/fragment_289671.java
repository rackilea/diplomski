int[] a = {1, 2, 3, 4, 5};
    int[] aR = new int[a.length];
    int index = 0;
    for (int i=a.length-1; i >=0; i--) {
            aR[index] = a[i];
            index++;
    }
    System.out.println(Arrays.toString(aR));