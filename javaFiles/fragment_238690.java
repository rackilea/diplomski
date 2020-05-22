public String addBinary(String A, String B) {
    return bin(num(A).add(num(B)));
}

public BigInteger num(String A) {
    return new BigInteger(A, 2);
}

public String bin(BigInteger A) {
    return A.toString(2);
}