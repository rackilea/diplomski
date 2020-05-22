String suit[] = {"Hearts", "Diamonds", "Spades", "Clubs"};
String value[] = {"ZZZZ", "Ace", "2", "3", "4", "5", "6", 
                  "7", "8", "9", "10", "Jack", "Queen", "King"};


String[] card = new String[5];  // only 5 cards are allowed here. Just example
String[] newSuit = String[5];

Scanner input = new Scanner(System.in);

for (int i = 0; i < 5; i++){
    System.out.println("Please enter a suit");
    int inputSuit = input.nextInt();
    System.out.println("Please enter a card");
    int inputValue = input.nextInt();

    switch (inputSuit) {
        case 0: newSuit[i] = suit[0]; break;
        case 1: newSuit[i] = suit[1]; break;
        case 2: newSuit[i] = suit[2]; break;
        case 3: newSuit[i] = suit[3]; break;
    }

    switch (inputValue) {
        case 1: card[i] = value[1]; break;
        case 2: card[i] = value[2]; break;
        case 3: card[i] = value[3]; break;
        case 4: card[i] = value[4]; break;
        case 5: card[i] = value[5]; break;
        case 6: card[i] = value[6]; break;
        case 7: card[i] = value[7]; break;
        case 8: card[i] = value[8]; break;
        case 9: card[i] = value[9]; break;
        case 10: card[i] = value[10]; break;
        case 11: card[i] = value[11]; break;
        case 12: card[i] = value[12]; break;
        case 13: card[i] = value[13]; break;
    }
}