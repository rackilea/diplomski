class Values {
    BigInteger number;
    BigInteger digitSum;

    Values(BigInteger number, BigInteger sum) {
        this.number = number;
        this.digitSum = sum;
    }

    @Override
    public String toString() {
        return number + " (digit sun:" + digitSum + ")";
    }
}