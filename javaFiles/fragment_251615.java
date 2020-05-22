int[] array = new int[size];
    try {
        Scanner in = new Scanner(System.in); //Import java.util.Scanner for it
        for (int j = 0; j < array.length ; j++) {
                int k = in.nextInt();
                array[j] = k;
        }
     }
     catch (Exception e) {
            e.printStackTrace();
     }