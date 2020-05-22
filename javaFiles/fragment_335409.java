public BigInteger toBigInteger(String foo)
{
    return new BigInteger(foo.getBytes());
}

public String fromBigInteger(BigInteger bar)
{
    return new String(bar.toByteArray());
}