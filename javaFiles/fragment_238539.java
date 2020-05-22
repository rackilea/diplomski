public static ArrayList<Integer> solve(int n, 
  ArrayList<Integer> moves, int bestMove,HashMap<Integer,Integer> memory) {

        if (moves.size() >= bestMove) return null;
        if (n == 1) return moves;
        Integer sizeOfPathN= memory.get(n);

        if (sizeOfPathN!=null && sizeOfPathN<=moves.size())return null;
        memory.put(n,moves.size());

        int size_1=Integer.MAX_VALUE, size_2 = Integer.MAX_VALUE, size_3 = Integer.MAX_VALUE;
        ArrayList<Integer> moves3 = null, moves2 = null, moves1;

        if (n % 3 == 0) {
            ArrayList<Integer> c = new ArrayList<Integer>(moves);
            c.add(3);
            moves3 = solve(n / 3, c,bestMove,memory);
            if (moves3!=null)
            size_3 = moves3.size();
        }

        bestMove = Math.min(bestMove, size_3);

        if (n % 2 == 0) {
            ArrayList<Integer> c = new ArrayList<Integer>(moves);
            c.add(2);
            moves2 = solve(n / 2, c,bestMove,memory);
            if (moves2!=null)
            size_2 = moves2.size();
        }

        bestMove = Math.min(bestMove, size_2);


        ArrayList<Integer> c = new ArrayList<Integer>(moves);
        c.add(1);
        moves1 = solve(n - 1, c,bestMove,memory);
        if (moves1!=null)
        size_1 = moves1.size();

        int r = Math.min(Math.min(size_1, size_2),size_3);
        if (r==size_1) return moves1;
        if (r==size_2) return moves2;

        return moves3;

    }