private int bddFromTuple(int[] tuple) {
     int result;
     result = bddManager.ref(intAsBDD(tuple[0],variables[0]));
     for(int i = 1; i < tuple.length; i++) {
         result = bddManager.ref(bddManager.and(result, intAsBDD(tuple[i], variables[i])));
     }
     return result;
}

private int intAsBDD(int intToConvert, int[] variables) {
    return bddFromBinaryArray(intAsBinary(intToConvert, variables.length), variables);
}
private int[] intAsBinary(int intToConvert, int bitCount) {
    String binaryString =  Integer.toBinaryString(intToConvert);
    int[] returnedArray = new int[bitCount];
    for (int i = bitCount - binaryString.length(); i < returnedArray.length; i++) {
        returnedArray[i] = binaryString.charAt(i - bitCount + binaryString.length()) - DELTAConvertASCIIToInt;
    }
    return returnedArray;
}

static int DELTAConvertASCIIToInt = 48;

private int bddFromBinaryArray(int[] intAsBinary, int[] variables) {
    int f;

    int[] tmp = new int[intAsBinary.length];

    for(int i = 0; i < intAsBinary.length; i++) {
        if(intAsBinary[i] == 0) {
            if (i == 0) {
                tmp[i] = bddManager.ref(bddManager.not(variables[i]));
            }
            else {
                tmp[i] = bddManager.ref(bddManager.and(tmp[i-1], bddManager.not(variables[i])));
                bddManager.deref(tmp[i - 1]);
            }
        }
        else {
            if (i == 0) {
                tmp[i] = bddManager.ref(variables[i]);
            }
            else {
                tmp[i] = bddManager.ref(bddManager.and(tmp[i-1], variables[i]));
                bddManager.deref(tmp[i - 1]);
            }
        }

    }
    f = tmp[tmp.length-1];
    return f;
}