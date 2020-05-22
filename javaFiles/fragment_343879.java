public static boolean compareStrings(String A, String B) {
    // write your code here
    int aLen = A.length();
    int bLen = B.length();
    if (aLen == 0) {
        return bLen == 0;
    }
    for(int i = 0; i<bLen; i++){
        String temp = B.substring(i,i + 1);
        if(A.contains(temp))
            A = A.replaceFirst(temp, "");
        else
            return false;
    }
    return true;
}