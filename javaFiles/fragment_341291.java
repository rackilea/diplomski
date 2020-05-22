public ArrayList<String> readFile(){
    File f = new File ("dictionary.txt"); 
    ArrayList<String> array = new ArrayList<String>();
    try {
        Scanner input = new Scanner (f);
        while (input.hasNext()){
                //Goes through all lines
            String line = input.nextLine();
                //Array of all words:
            String[] wordArray = line.split(" "); 
                //Goes through all words:
            for(String str : wordArray){
                array.add(str);
            }

        }
        input.close(); 
    }//try
    catch (IOException e) {
        e.printStackTrace(); 
    }
  return array;
}