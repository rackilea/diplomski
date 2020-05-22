public static int recursiveMethod (int x, int y, int z, int q, int largestVar)
{
    int xRes = x % q;
    int yRes = y % q;
    int zRes = z % q;
    if (xRes==0 && yRes ==0 && zRes==0) {
    //A common denominator found!
                largestVar = q;
    }
    //regardless whether a denominator was found, check for the termination condition
    //Or works here, by the way, since we only need to know when q is greater than one of them.
    if (q >= x || q >= y || q >= z) {
        return largestVar;
    }
    //if we don't terminate, increment q and recurse. 
    q++;
    return recursiveMethod(x, y, z, q, largestVar);
}