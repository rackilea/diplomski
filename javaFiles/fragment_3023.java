class NaturalNumber {

    private int value;

    public NaturalNumber(int naturalValue) {
        this.value = naturalValue;
    }
    // ...
}

class EvenNumber extends NaturalNumber {

    public EvenNumber(int oddValue) {
        super(oddValue);
    }
    // ...
}