//Creates an array that gets n amount of multiples of 5
    public static int[] getMultiplesOfFive(int n){
        int [] temp = new int[n];
        for(int i=0; i<temp.length; i++){
            temp[i] = (i+1)*10;
        }
        return temp;
    }

    //Creates an array that gets n amount of multiples of 10
    public static int[] getMultiplesOfTen(int n){
        int [] temp = new int[n];
        for(int i=0; i<temp.length; i++){
            temp[i] = (i+1)*10;
        }
        return temp;
    }