static int solve(char[] a) { //given a row, calculate the maximum number of catches
        int ret = 0;
        ArrayDeque<Integer> policeMenQueue = new ArrayDeque<>(); // queue for holding positions of policemen
        ArrayDeque<Integer> thievesQueue = new ArrayDeque<>(); // queue for positions of thieves
        for (int i = 0; i < n; i++) {
            if(!policeMenQueue.isEmpty()) { // check if the leftmost policeman can catch a thief at current position (i)
                Integer mostLeftPoliceMan = policeMenQueue.getFirst();
                if(i - mostLeftPoliceMan > k) { // if he cannot then we must remove him as he will no longer be able to catch any thieves
                    policeMenQueue.removeFirst();
                }
            }
            if(!thievesQueue.isEmpty()) { // check if the leftmost thief can be caught be a policeman at current position (i)
                Integer mostLeftThief = thievesQueue.getFirst();
                if(i - mostLeftThief > k) { // if not then we must remove him as he will no longer be caught by any policemen
                    thievesQueue.removeFirst();
                }
            }
            if(a[i] == 'P') {
                if(!thievesQueue.isEmpty()) { // the leftmost thief can be caught by current policeman
                    ret++;
                    thievesQueue.removeFirst(); // ok this thief is caught, remove him
                } else {
                    policeMenQueue.addLast(i); // just add the policeman to keep his position in the queue
                }
            }
            if(a[i] == 'T') {
                if(!policeMenQueue.isEmpty()) { // the current thief can be caught by the leftmost policeman
                    ret++;
                    policeMenQueue.removeFirst(); // ok this policeman has already caught a thief (used), remove him
                } else {
                    thievesQueue.addLast(i); // just add the thief to keep his position in the queue
                }
            }
        }
        return ret;
    }