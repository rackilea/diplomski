boolean found = false;
 File file = new File("c:/example/filedata.txt");
 FileReader fileReader = new FileReader(file);
 BufferedReader bufferedReader = new BufferedReader(fileReader);
 while ((temp = bufferedReader.readLine()) != null) {
   if(s5.equals(temp)) {
     System.out.println("file already exist");
     found = true;
     break;
   }
 }
 if (!found){
    PrintWriter fileWriter = new PrintWriter(new    
    FileOutputStream("c:/example/filedata.txt",true));  
    fileWriter.println( s5 );
    System.out.println("file saved");
 }