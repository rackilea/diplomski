public static boolean IsItPrime(int sPrime) {
    if (sPrime % 2 == 0 && sPrime != 2) {
        return false;
    }

    int sqrtPrime = (int)Math.sqrt(sPrime);
    for (int i = 3; i <= sqrtPrime; i += 2) {
        if (sPrime % i == 0) {
            return false;
        }
    }

    return true;
}