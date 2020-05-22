if (hand < 4) {
                int newcounter = 0;
                for (int j = 0; j < length; j++) {
                    if (counts[j] == 2) {
                       newcounter++;
                    }
                }
                if (newcounter==2) {
                        hand = 3;
                    }
                if (newcounter == 1) { hand = 2; }
}