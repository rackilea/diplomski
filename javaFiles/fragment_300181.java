/**
     * Returns a BigInteger whose value is (this-1 mod m).
     *
     * @param  m the modulus.
     * @return this-1 mod m.
     * @throws ArithmeticException  m <= 0, or this BigInteger
     *         has no multiplicative inverse mod m (that is, this BigInteger
     *         is not relatively prime to m).
     */
    public BigInteger modInverse(BigInteger m) {
        if (m.signum <= 0)
          throw new ArithmeticException("Modulus not positive: " + m);
        if (!this.gcd(m).equals(ONE))
          throw new ArithmeticException(this + " not invertible mod " + m);

        ... // Do the computation

        assert this.multiply(result).mod(m).equals(ONE);
        return result;
    }