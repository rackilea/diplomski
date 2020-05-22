public static void main(String[] args) throws FileNotFoundException {

  Scanner s = new Scanner(new File("D:/trabalho/maze.txt"));
  ArrayList<String> list = new ArrayList<String>;
  while (s.hasNextLine()){
      list.add(s.nextLine());
  }
  s.close();
  System.out.println(list);
}