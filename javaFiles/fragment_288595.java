System.out.println("Give your phrase : ");
    Scanner scan = new Scanner(System.in);
    String Phrase;
    Phrase = scan.nextLine();
    System.out.println("Enter age : ");
    int number = scan.nextInt();
    // replace the number with empty string mean nothing
    Phrase = Phrase.replace(String.valueOf(number), "");
    Phrase = Phrase.concat(" "); // add space at end for loop calculation 
    int TotalSizeOfPhrase = 0;   // set tot =0
    int count=0; // a count variable to keep track of the word length
    for (int i=0; i<Phrase.length(); i++)
    {
        count++;
        if(Character.isWhitespace(Phrase.charAt(i)))
        {
            if(count-1>1){ // if size of word ( -1 is there for space size) 
                           // is greater than 1 than increment count
                TotalSizeOfPhrase=TotalSizeOfPhrase+1;                          
            }
            count=0;            
        }
    }
    System.out.println(TotalSizeOfPhrase);
    scan.close();// don't forget