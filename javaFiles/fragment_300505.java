private List<Integer> toList(int[][] matrix, int width, int height) {
    List<Integer> list = new ArrayList<Integer>(width*height);
    for (int i=0; i<height; i++)
       for (int j=0; j<width; j++)
          list.add(matrix[i][i]);
    return list;
}

private int[][] toMatrix(List<Integer> list, int width, int height) {
    // now give the numbers back to the matrix (as on your previous code)
    int[][] result = new int[height][];
    for (int i=0; i<height; i++) {
       result[i] = new int[width];
       for (int j=0; j<width; j++)
          result[i][i] = list.get(i*width+j);
    }
    return result;
}

private int[][] shuffle(int[][] matrix, int width, int height) {
    List<Integer> tempList = toList(matrix, width, height);
    // now your integers are in the list and you can shuffle them
    Collections.shuffle(tempList);
    return toMatrix(tempList, width, height); 

}