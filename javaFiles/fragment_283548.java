List<Integer> arraylist0 = Arrays.asList(2,4,3);
    List<Integer> arraylist1 = Arrays.asList(2,5,7);
    List<Integer> arraylist2 = Arrays.asList(6,3,7);
    List<List<Integer>> arraylistList = Arrays.asList(arraylist0, arraylist1, arraylist2);

    int size = 3;
    int[] myArray0 = new int[size];
    int[] myArray1 = new int[size];
    int[] myArray2 = new int[size];
    int[][] myBigArray = new int[][] {myArray0, myArray1, myArray2};

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            myBigArray[i][j] = arraylistList.get(j).get(i);
        }
    }