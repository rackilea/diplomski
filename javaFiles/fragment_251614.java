int[] array = new int[size];
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < array.length ; j++) {
                int k = Integer.parseInt(br.readLine());
                array[j] = k;
        }
     }

    catch (Exception e) {
            e.printStackTrace();
     }