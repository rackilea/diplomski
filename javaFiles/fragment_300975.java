public static void prime(int[] list){
    boolean isPrime = true;
    int count = 0;

    for (int i = 0; i < list.length; i++){
        isPrime = true;
        if (i < 2) {
          isPrime = false;
        } else {
            for (int j = 2; j * j <= list[i]; j++){
                count = i;
                if (list[i] % j == 0){
                    isPrime = false;
                    break;
                }
                if (list [i] == 2){
                    isPrime = true;
                    list[i] = -1;
                }
            }
        }
        if (isPrime){
            list[i] = -1;
        }

    }
}