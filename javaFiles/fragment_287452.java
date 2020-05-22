while (x < 4){
        String suite = possuite[x];
        int number = 1;
        System.out.println(suite);

        while (number < 14){
            int cardPos = (number-1) + (13*x);
            deck[cardPos] = new Card();


            deck[cardPos].Suite = suite;
            deck[cardPos].Number = number;
            number++;
       }
       x++;