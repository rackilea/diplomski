private void shuffle(int[][] matrix, int width, int height) {
    List<Integer> tempList = new ArrayList<Integer>(width*height);
    for (int i=0; i<height; i++)
       for (int j=0; j<width; j++)
          list.add(matrix[i][i]);

    // now your integers are in the list and you can shuffle them
    Collections.shuffle(tempList);

    // now give the numbers back to the matrix (as on your previous code)
    for (int i=0; i<height; i++)
       for (int j=0; j<width; j++)
          matrix[i][i] = tempList.get(i*width+j);
}