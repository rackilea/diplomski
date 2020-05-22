public static String[] populate(){
    String[] cards=new String[52];
    String[] types={"hearts", "spades", "clubs", "diamonds"};
    int current = 0;
    for(String type:types)
        for(int i = 1; i <= 13 ; i++)
            cards[current++] = i + "_of_" + type;

    return cards;
}