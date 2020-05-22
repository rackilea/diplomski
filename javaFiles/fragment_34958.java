Scanner in = new Scanner(new FileInputStream("Avar.txt"));

while(in.hasNextLine){
    Scanner lineScanner = new Scanner(in.nextLine());
    if(lineScanner.hasNextInt()){
        int x = lineScanner.nextInt();
        // do something with x
    }

}