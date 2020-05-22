// This must run in a NON-UI thread!
   //===================================== 
   try {
     for (String chunk: expression.split("\n")) {
        if (chunk.charAt(0) == 'd') {
            int valor; 
            if (chunk.length() > 1 &&
                (valor = Integer.parseInt(chunk.substring(1)))> 0) {
                    System.out.println("Delay " + valor + " millisec");
                    Thread.sleep(valor);
             }
        } else 
            MenuActivity.mOut.write(chunk.getBytes());

      } // End of for loop
    } catch(InterruptedException ex) {
         System.out.println("Cancelled");
    }

   }