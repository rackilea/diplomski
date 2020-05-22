Random rand = new Random();
        int a = 0 ; 
        while (!done) { 
            int a = rand.nextInt(10) ; //<-- the one declared above
            if (debug){ stuff ; }
            if (possibles[a]==1){ done = true ; } 
        }