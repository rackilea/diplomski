public static void printFactors(int z) {
    for(int x=1; x * x <= z; x++) {
        if(z % x == 0) {
            System.out.println(x);
            if(x * x != z) System.out.println(z / x);
        }
    }
}