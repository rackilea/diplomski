void generateCSV(File myFile) throws IOException {
     PrintWriter pw = new PrintWriter(new FileWriter(myFile));
     for(int i= 0; i < 1000; i++) {
       pw.print(String.format("(%f, %f)%n", ProtonTracking[i][0], ProtonTracking[i][1]));
     }
  }