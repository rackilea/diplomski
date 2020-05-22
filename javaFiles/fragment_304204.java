File inputTXT = new File (fileName);
    Scanner in=null;
    try{
     in = new Scanner(inputTXT);
    }catch(FileNotFoundException e){
        System.out.println("");
    }
        while(in.hasNext()){
            String line = in.nextLine();