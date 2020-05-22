String authorString = "Originally Posted By:";
Scanner scanner = new Scanner(realClean);
try {
  while ( scanner.hasNextLine() ){
    String line = scanner.nextLine();
    if(line.contains(authorString){
       Log.d("AUTHORS!", line.split(authorString)[1] + "\n");
  }
}