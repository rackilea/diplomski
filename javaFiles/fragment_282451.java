public enum Something {
    CAR (1),
    HOUSE (2),
    DOG (3),

    private int value;

    private Something(int value) {
         this.value = value;
    }

    public int getValue() {
         return value;
    }
}