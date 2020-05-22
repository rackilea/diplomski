public static void main(String[] args)
  {
     findStuff calc = new findStuff();
     try {
         calc.findSyl();
         calc.printRes();
     }
     catch (IOException ex) {
         // handle the exception here
     }  
  }