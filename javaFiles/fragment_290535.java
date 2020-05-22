String[] suits = {"Hearts","Diamonds","Spades","Clubs"};
    String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    // The size of the 2-d must be pre-initialized
    String[][] Cards = new String[suits.length][numbers.length];

    int i = 0; //suit index
    int j = 0; //number index

    for(String suit : suits){
        for(String number : numbers){
            Cards[i][j] = number+" of "+suit;
            j++;
        }
        i++;
        j=0; // we have to return to the starting index to reset the number
    }