public static void outputArray(int[][] array) {
    for(int i = 0; i < array.length; i++){
        for(int j = 0; j< array[i].length; j++){
            for(int k = i; k < array.length; k++){
                for(int l = j; l < array[i].length; l++){
                    System.out.print("["+i+","+j+"]--->"+"["+k+","+l+"]");
                    int sum = 0;
                    for(int x = i; x <= k; x++){
                        for(int y = j; y<= l; y++){
                            sum+=array[x][y];
                        }
                    }
                    System.out.println("--->"+sum);
                }
            }
        }
    }
}