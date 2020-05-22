if (hand < 6) {
                int counter3 = 0;
                int counter2 = 0;
                for (int j = 0; j < length; j++) {
                     if (counts[j] == 3) {
                        counter3++;
                     }
                     if (counts [j] == 2) {
                        counter2++;
                     } 
                }
                if (counter3 == 1 && counter2 == 1) {
                    hand = 5;
                }
            }