Card[] myCards = new Card[15];
// only run this if the file has at least 1 line, and only run once
if (fileScanner.hasNextLine())
{
    String line = fileScanner.nextLine();
    Scanner lineScanner = new Scanner(line);
    lineScanner.useDelimiter(", ");

    for(int i = 0; i < 15; i++)
    {

        // read in one card
        if (lineScanner.hasNext())
        {
            String cardType = lineScanner.next();
            String message = lineScanner.next();
            Double amount = lineScanner.nextDouble();

            //creates a card
            Card myCard = new Card(cardType, message, amount);
            myCards[i] = myCard;
        }
    }
}