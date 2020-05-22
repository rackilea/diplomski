for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] > 9) {
            System.out.print(arr[i][j]+"  ");
        }else{
            System.out.print(arr[i][j]+"   ");
        }
    }
    System.out.println();
}