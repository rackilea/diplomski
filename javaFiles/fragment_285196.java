public static boolean isSymmetrical(String inputText)
  {
      inputText = inputText.toLowerCase();

      if(inputText.length() == 0 || inputText.length() ==1)
          return true;

      if(!Character.isLetter(inputText.charAt(0)))
        return isSymmetrical(inputText.substring(1,inputText.length()));

      if(!Character.isLetter(inputText.charAt(inputText.length()-1)))
        return isSymmetrical(inputText.substring(0,inputText.length()-1));      

      if(inputText.charAt(0) == inputText.charAt(inputText.length()-1))
          return isSymmetrical(inputText.substring(1,inputText.length()-1));

      return false;
  }