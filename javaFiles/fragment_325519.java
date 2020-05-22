public static void getBooks()throws FileNotFoundException{

  Scanner input = new Scanner(bookFile);
  String line = input.nextLine();
  int bookNum = 1;

  while (input.hasNextLine()) {
     bookNum += 1;
     line = input.nextLine();
  }
  input.close();

  input = new Scanner(bookFile);
  if(scanner.hasNextLine(){
  line = input.nextLine();

  bookarray = new String[3][bookNum];

  for (int y = 0; y < bookNum; y++){
     bookarray [0][y] = line.substring(0,10);
     bookarray [1][y] = line.substring(11,15);
     bookarray [2][y] = line.substring(17,18);
     if(!line.hasNextLine()){break;}
     line = input.nextLine();
  } 
  }    

}