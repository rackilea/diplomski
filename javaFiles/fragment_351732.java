private static Set<String> posible2(String posLoc) {
      Set<String> result = new TreeSet<String>();
      BufferedReader br = null;
      try {
         br = new BufferedReader(new FileReader(new File(posLoc)));
         String availalbe;
         while((availalbe = br.readLine()) != null) {
             result.add(availalbe);            
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (br != null) {
            try {
               br.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
      return result;
  }