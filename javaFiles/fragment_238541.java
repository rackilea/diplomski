public static int solve(int n,int moves,int bestMove,HashMap<Integer,Integer> memory) {

        if (moves >= bestMove) return Integer.MAX_VALUE;
        if (n == 1) return moves;
        Integer sizeOfPathN= memory.get(n);

        if (sizeOfPathN!=null && sizeOfPathN<=moves)return Integer.MAX_VALUE;
        memory.put(n,moves);

        int size_1=Integer.MAX_VALUE;
        int size_2 = Integer.MAX_VALUE;
        int size_3 = Integer.MAX_VALUE;

        moves=moves+1;
        if (n % 3 == 0) size_3 = solve(n / 3, moves,bestMove,memory);
        bestMove = Math.min(bestMove, size_3);      
        if (n % 2 == 0) size_2=solve(n >> 1, moves,bestMove,memory);

        bestMove = Math.min(bestMove, size_2);

        size_1 = solve(n - 1, moves,bestMove,memory);


        return  Math.min(Math.min(size_1, size_2),size_3);


    }