public static void main(String[] args)
  {
    String hex[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
    String binary[] = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011",
        "1100", "1101", "1110", "1111" };
    String result = " ";
    boolean containcharacterOtherthan1or0 = false;
    System.out.println("enter the number :");
    Scanner num = new Scanner(System.in);
    String userInput = num.next();
    System.out.println("You entered " + userInput);
    for (int k = 0; k < userInput.length(); k++)
    {
      if (!String.valueOf(userInput.charAt(k)).equals("0") && !String.valueOf(userInput.charAt(k)).equals("1"))
        containcharacterOtherthan1or0 = true;
    }
    if (userInput.length() % 4 == 0 && !containcharacterOtherthan1or0)
    {

      for (int i = 0; i < userInput.length(); i = i + 4)
      {
        for (int j = 0; j < binary.length; j++)
        {
          if (binary[j].equals(userInput.substring(i, i + 4)))
          {
            result += hex[j];
          }
        }

      }

      System.out.println("the result is :" + result);
    }
    else
    {
      System.out.println("enter a binary number with length of muliplier of 4 ");
    }

  }