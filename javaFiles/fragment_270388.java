public static void main(String[] args) throws FileNotFoundException {

  Scanner sc = new Scanner(System.in);
  while(true){ //Runs until it is specified to break

    System.out.println("Enter filename");
    String fileName = sc.nextLine();
    File file = new File(fileName);
    if(!file.exists()) {
      continue;
    }

    processFile(fileName);

  }
}