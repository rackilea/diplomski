public static void main(String[] args){

    int[][] data = new int[][]{ {1,4,3},
                                {2,1,4},
                                {3,2,1},
                                {4,3,2}};
    int row = data.length;
    int col = data[0].length;

    System.err.println(row+" rows");
    System.err.println(col + " columns");

    List<List<Integer>> clusters = new ArrayList<>(row);
    for(int i=0; i< row; i++){
        clusters.add(new ArrayList<Integer>(col));
    }

    List<Integer> temp = new ArrayList<>(col);

    for(int i=0; i< col; i++){
        temp.clear();
        for(int j=0; j< row; j++){
            temp.add(data[j][i]);
        }
        System.err.println(temp);
        Collections.sort(temp);
        for(int x = 0; x < row; x++){
            clusters.get(x).add(temp.get(x));
        }
    }
    System.err.println("Results");
    System.err.println(clusters);
}