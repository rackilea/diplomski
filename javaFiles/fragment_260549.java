public int fromScanner2(Scanner scanner, String letter){ 
      int result = 0;
      String resultS = null;
      while( (resultS = scanner.findWithinHorizon(letter, 0)) !=null ){
           ++result;
      }
      return result;
 }