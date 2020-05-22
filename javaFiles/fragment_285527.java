int[] initialArray = new int[]{1,2,3};
    System.out.println(initialArray[0] + " " + initialArray[1] + " "+ initialArray[2]);
    int[][] newArray = new int[initialArray.length][3];
    for (int i=0;i<initialArray.length;i++){
        newArray[i][0] = initialArray[i];
    }
    System.out.println(newArray[0][0] + " " + newArray[1][0] + " "+ newArray[2][0]);