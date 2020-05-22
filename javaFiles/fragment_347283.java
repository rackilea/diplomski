for(int y = randRow - 1; y < randRow + 2; y++) {
                for(int x = randCol - 1; x < randCol + 2; x++) {
                    if(y != randCol || x != randRow) {
                        bombIterate(y, x);
                    }
                }
            }