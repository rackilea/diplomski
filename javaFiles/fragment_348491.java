try ( Reader r = ...;
          BufferedReader br = new MyBufferedReader(r)) {
     String line;
     while ((line = br.readLine()) != null) {
         // use returned line
     }
}