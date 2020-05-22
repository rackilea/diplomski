public static byte[] readSomeFile(String filePath) {
         byte[] buffer = new byte[FILE_SIZE];
         int size = 0;
         byte[] someArray= null;
         try (FileInputStream fileIn = new FileInputStream(filePath);
                 BufferedInputStream buffIn = new BufferedInputStream(fileIn);
                 DataInputStream inData = new DataInputStream(buffIn);) {

          size = inData.read(buffer, 0, FILE_SIZE);
          someArray= new byte[size];
          System.arraycopy(buffer, 0, someArray, 0, size);
         } catch (IOException e) {
          //log(Log.ERROR,"IO ERROR: " + e.toString());
         } 
         return someArray;
    }