@Benchmark
    public BigInteger loop() {
        return n > 92 ?
                loop(n - 91, BigInteger.valueOf(4660046610375530309L), BigInteger.valueOf(7540113804746346429L)) :
                BigInteger.valueOf(fastLoop(n, 0, 1));
    }