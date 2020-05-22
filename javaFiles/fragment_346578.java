public static String generateKString(String binary){
    // k is the smallest positive number the actual binary scheme cannot represent
    // for 1101 it is 1000
    String kStr = "1";
    for(int i = 1; i < binary.length(); i++)
        kStr += "0";
    return kStr;
}

public static BigInteger convertSignedBigInt(String binary){
    BigInteger bInt = new BigInteger(binary, 2);        
    String kStr = generateKString(binary);      
    BigInteger k = new BigInteger(kStr, 2);     
    if (bInt.compareTo(k) == 1) bInt = bInt.subtract(k.multiply(new BigInteger("2")));
    return bInt;
}

public static int convertSignedInt(String binary){
    int i = Integer.parseInt(binary, 2);
    String kStr = generateKString(binary);
    int k =  Integer.parseInt(kStr, 2);
    if (i >= k) i -= 2 * k;
    return i;
}