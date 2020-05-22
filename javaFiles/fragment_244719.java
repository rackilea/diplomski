private void fileRead(){
    try{    
        FileReader read = new FileReader("filepath");
        Scanner scan = new Scanner(read);
            while(scan.hasNextLine()){
            String temp = scan.nextLine() + System.lineSeparator();
            storeAllString = storeAllString + temp;
        }
    }
    catch (Exception exception) {
        exception.printStackTrace();
    }
}