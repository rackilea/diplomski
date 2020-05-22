public static int getTotal(int[][] numbers) {
        int total = 0;
        for (int [] x : numbers){
            for (int y : x){
                total = total + y;
            }
        }
        return total;
    }