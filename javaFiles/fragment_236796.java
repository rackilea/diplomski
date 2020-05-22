private static void colourRead() throws IOException
{
    FileReader readhandle = new FileReader("C:\\****\\****");
    BufferedReader br = new BufferedReader(readhandle);
    String line = null;
    while((line = br.readLine()) != null)
    {
      ColourText(line); //there's an error here
    }

    br.close();
    readhandle.close();
}

private static void ColourInput() 
{

  String fullWord;
  Scanner kb = new Scanner(System.in);

  System.out.print("Enter whatever: ");

  fullWord = kb.nextLine();
  System.out.println(fullWord);
  ColourText(fullWord);
}

private static void ColourText(String text)
{

    char letter;
    for (int i = 0; i < text.length(); i++)
    {
      letter = text.charAt(i);
      switch(Character.toUpperCase(letter))
      {
          case 'A':
          {
             Blue();
          }
          break;
      }
}