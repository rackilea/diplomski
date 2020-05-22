int size_num = Integer.parseInt(size);
int[][]  A = new int[size_num][size_num];
if (size_num > 1 && size_num < 4) {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  for(int row = 0; row < size_num ; row++)
    for(int col = 0 ; col < size_num ; col++){
        String ipS = br.readLine();
        int input_value = Integer.parseInt(ipS);
        A[row][col] = input_value;
  }
} else {
  System.out.println("invalid matrix size!");
}
return A;