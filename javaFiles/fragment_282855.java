letters = new char[]{'a','A','a','A','a','A','b','B','c','c','C','d','d','F','d','d'
            ,'d','e','E','f','F','f'};
            counts = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

            for (char letter : letters) {
                final int index = letter-'A';
                counts[index % 32]++;
            }