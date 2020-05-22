public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter("file.txt", "UTF-8");
            try{

              //Create object of FileReader
              FileReader inputFile = new FileReader("csv.txt");

              //Instantiate the BufferedReader Class
              BufferedReader bufferReader = new BufferedReader(inputFile);

              //Variable to hold the one line data
              String line;
              String date="";String org ="";String student ="";
              // Read file line by line and print on the console
              while ((line = bufferReader.readLine()) != null)   {
                  if(line.contains("1.")){
                      if(date!="" || org!=""){
                          writer.println(date+","+org+","+student);
                          student ="";
                       }
                         date = line.substring(2);
                        }else if(line.contains("2.")){
                            org = line.substring(2);

                      }else{
                            line = "("+line+")";
                          student += line+",";
                  }

                    System.out.println(line);
              }
              writer.println(date+","+org+","+student);
              //Close the buffer reader
              bufferReader.close();
      }catch(Exception e){
        System.out.println("Error while reading file line by line:" + e.getMessage());                      
   }
       writer.close();
  }