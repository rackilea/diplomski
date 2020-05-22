public static void main(String[] args) throws IOException {

     File outFile = new File(System.getProperty("user.home") + "/Desktop/output.txt"); // file into users homedir

     System.out.println(outFile.getAbsolutePath()); // print it's location in console

     PrintWriter out = new PrintWriter(outFile); // writer over that file

     Files.walk(Paths.get("C:/Location")).forEach(filePath -> {
         if (Files.isRegularFile(filePath)) {

             out.print(filePath);

             }    
         }); 
     out.close();
    }
}