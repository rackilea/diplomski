private BigInteger calculateE(BigInteger n, byte[] message)
{
    /* n is curve order value */
    int log2n = n.bitLength();
    /* and message is a hash */
    int messageBitLength = message.length * 8;

    BigInteger e = new BigInteger(1, message);
    /* If message is longer than curve order */
    if (log2n < messageBitLength)
    {
        /* only log2n bits are taken from the left */
        e = e.shiftRight(messageBitLength - log2n);
    }
    return e;
}