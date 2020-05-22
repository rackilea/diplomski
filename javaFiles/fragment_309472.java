public static void ascending(int[] array) {

        int timesLooped = 0;
        boolean sorted = false;
        while(!sorted) {
            sorted = true;

            for(int i = 0; i < array.length - timesLooped - 1; i++) {
                if(array[i] > array[i + 1]) {
                    swapElements(array, i, i + 1);
                    sorted = false;
                }
            }
            timesLooped++;              
        }
    }