public static void main(String[] args) throws FileNotFoundException {

  Scanner s = new Scanner(new File("D:/trabalho/maze.txt"));
  String[][] list = new String[10][5];
  for(int x = x; s.hasNextLine();x++ ){
   for(int i = 0; i < 5 ; i++){
      list[x][i] = s.nextLine();
   }
 }
  s.close();
  System.out.println(list);

}