public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    openFile(file);
    int[] line = new int[3];
    while (nextLine()) {
          try{   
        line = readLine();
        String output = getLineOutput(line);
        System.out.println(output);
        }catch(NoSuchElementException e) { System.out.println("No such element exception"); }
    } 
    scan.close();

}