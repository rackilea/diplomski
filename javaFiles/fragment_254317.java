public void calculateFileCharecteristics(String fileName){
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new 
    File(filename)))){
        String line;
        int lineCount = 0;
        int totalCharCount = 0;
        while((line=bufferedReader.readLine())!=null){
            lineCount++; 
            int charCount = line.split("\n").length;
            totalCharCount +=charCount;
        }
    }
}