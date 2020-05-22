private static int bubbleSort(int[] BubArray) {

        int z = BubArray.length;
        int temp = 0;

        int itrs = 0;

        for(int a = 0; a < z; a++){
                for(int x=1; x < (z-a); x++){

                        if(BubArray[x-1] > BubArray[x]){

                                temp = BubArray[x-1];
                                BubArray[x-1] = BubArray[x];
                                BubArray[x] = temp;


                        }    

                        itrs++;
                }
        }

        return itrs;