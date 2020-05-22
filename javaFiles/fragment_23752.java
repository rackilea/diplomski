public static void main(String[] args) {

      Scanner kb = new Scanner(System.in);
      System.out.println("Enter a binary number: ");
      String bin = kb.nextLine();
      int oneCount = 0;
      boolean validBinaryNum = true;

      for (int i = 0; i < bin.length() && validBinaryNum; i++) {
          char currentChar = bin.charAt(i);
          if (currentChar == '1') oneCount++;
          else if (currentChar != '0') {
              validBinaryNum = false;
          }
      }

      if (validBinaryNum && bin.length() != 0) {
          System.out.println("Number of 1's: " + oneCount);
      } else {
          System.out.println("Number is not binary");
      }

}