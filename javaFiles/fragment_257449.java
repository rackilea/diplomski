public void countSymbols() throws IOException{
    int count = 0;
    try(FileReader reader = new FileReader(fileIn)) {
        int cread;
        while((cread = reader.read()) != -1){
            //if(!reader.equals(" "))
                count++;
        }
    }
    try(FileWriter fw = new FileWriter("donati")) {
        fw.write(Integer.toString(count));
    }
}