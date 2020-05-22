BufferedReader fileIn = null;
 try {
       fileIn = new BufferedReader(new FileReader(filename));
       //etc.
 } catch(IOException e) {
      fileArrayList.removeall(fileArrayList);
 } finally {
     try {
       if (fileIn != null) fileIn.close();
     } catch (IOException io) {
        //log exception here
     }
 }
 return fileArrayList;