ArrayList<String> peices = new ArrayList<String>();

     while(inputFile.hasNextLine()){
         String peice = "";
         peice += inputFile.nextLine() + " ";
         peice += inputFile.nextLine() + " ";
         peice += inputFile.nextLine() + " ";
         peice += inputFile.nextLine() + " ";
         peices.add(peice);
     }