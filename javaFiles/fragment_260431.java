public static Map<Integer, Integer> Factorize(int n){
    HashMap<Integer, Integer> ret = new HashMap<Integer, Integer>();
    int origN = n;
    for(int p = 2; p*p <= origN && n > 1; p += (p == 2 ? 1: 2)){
        int power = 0;
        while (n % p == 0){
            ++power;
            n /= p;
        }
        if(power > 0)
            ret.put(p, power);
    }

    return ret;
}