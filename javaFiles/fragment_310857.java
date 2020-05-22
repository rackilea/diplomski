public static int solve(int n) {

        int[] map=new int[n+1];
        map[0]=1;
        map[1]=1;
        map[2]=2;
        for (int i = 3; i < map.length; i++) {
                map[i]+=map[i-1];
                map[i]+=map[i-2];
                map[i]+=map[i-3];
        }
        return map[n];
    }