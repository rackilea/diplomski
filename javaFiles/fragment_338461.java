for(int a = 0; a<ranks.length; a++){
        for(int b=0; b<suits.length;b++){
            cards.add(new Card(ranks[a],suits[b], 0));
            System.out.println(cards);
            size+=1;
        }
    }
}