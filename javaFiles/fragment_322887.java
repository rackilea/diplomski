int rows = 3, columns = 4;
    ArrayList<Integer> Arr1;
    ArrayList<ArrayList<Integer>> Arr2 = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
        Arr1 = new ArrayList<>();
        for (int j = 0; j < columns; j++) {
            Arr1.add(j);
        }
        Arr2.add(Arr1);
    }
    System.out.println(Arr2);