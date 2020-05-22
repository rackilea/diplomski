enum SampleEnum {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5, 100);

    private SampleEnum(int value){
        this.low = value;
        this.high = value;
    }
    private SampleEnum(int low, int high) {
        this.low = low;
        this.high = high;
    }

    private final int low;
    private final int high;
}