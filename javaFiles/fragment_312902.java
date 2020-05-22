public static String[] rotate(String [] toRotate)
  {

      String [] returnChar = new String[toRotate[0].length()];
      String [] result = new String[toRotate[0].length()];
      Arrays.fill(returnChar, "");

      for(int rows = 0; rows<toRotate.length; rows++)
          for(int cols = 0 ; cols < toRotate[rows].length(); cols++)
              returnChar[cols] = returnChar[cols] + toRotate[rows].charAt(cols);

      for(int i = 0; i < returnChar.length; i++)
          result[i] =  new StringBuffer(returnChar[i]).reverse().toString();

      return result;
  }