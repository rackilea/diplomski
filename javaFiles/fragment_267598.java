public static void main(String[] args)
{
    Random RNG = new Random(); //Set up the RNG
    Scanner scan = new Scanner( System.in ); //Set up the scanner
    System.out.println("Enter the phrase to be shortened: ");
    String toCompress = scan.nextLine();
    //Setup the string builder with the user input
    StringBuilder shorten = new StringBuilder(toCompress); 

    //Wile the length is greater than or equal to 140,do some conversions then 
    //run the if statement
    while (shorten.length() >= 140)
    {
        int randChar = RNG.nextInt(shorten.length());
        char convertToChar = shorten.charAt(randChar);
        int convertToInt = (int)convertToChar;

        //If statement choosing which ASCII chars to delete (vowels)
            if ((convertToInt > 32) || (convertToInt == 65)
                    || (convertToInt == 69) || (convertToInt == 73)
                    || (convertToInt == 79) || (convertToInt == 85))
                        {
                            shorten.deleteCharAt(randChar);
                        }
    }
    System.out.println("Compressed phrase:");
    System.out.println(shorten);
    System.out.println(shorten.length());

    scan.close();   
}}