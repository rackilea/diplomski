public List<string[]> csvToList(String csvFileToRead){
     BufferedReader br = null;    
     String line = "";    
     String splitBy = ";";    
     try {    

      br = new BufferedReader(new FileReader(csvFileToRead));

       List<string[]> list_csv = new ArrayList<string[]>();
       while ((line = br.readLine()) != null) {    

        String[] book = line.split(splitBy);    
        authors.add(book);
       }
       catch(Exception ex) {}

       return list_csv;
}