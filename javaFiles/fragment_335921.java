private String line = ""; // a class field

   public void checker() {
      try {

         while ((line = reader.readLine()) != null) {

            System.out.println(line);
            SwingUtilities.invokeLater(new Runnable() {
               TextArea.append(line + "\n");
            });
         }

      } catch (Exception ex) {
         System.out.println("checker is crying: " + ex);
      }
   }


   public void run() {
      checker();
   }