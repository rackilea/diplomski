public static int[][] solve(int[][] a) {
    int[] freeslot = findfreeslot(a);
    int f1 = freeslot[0];
    int f2 = freeslot[1];
    if (f1 == -1) {
        return a;
    }
    a = teilsolve(f1, f2, a);
    return a;
}

public static int [][] teilsolve(int f1, int f2, int[][] a) {
    int [][] temp2;
    int[][] temp = new int[a.length][a[0].length];
    for (int y = 0; y < a.length; y++) {
        for (int z = 0; z < a[0].length; z++) {
            temp[y][z] = a[y][z];
        }
    }
    for (int i = 1; i < 10; i++) {
        temp[f1][f2] = i;
        boolean valide = isValid(temp);
        if (valide) {
            temp2 = solve(temp);
            if (temp2 != null) {return temp2;}
        }
    }
    return null;
}