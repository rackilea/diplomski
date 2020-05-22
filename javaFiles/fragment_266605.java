class DMK {
    private static final int FIELD_M = 0;
    private static final int FIELD_D = 1;
    private static final int FIELD_C = 2;
    private static final int FIELD_I = 3;
    private static final int FIELD_IP = 4;
    private static final int FIELD_MJ = 5;
    private static final int FIELD_PLACEHOLDER1 = 6;

    private SlidingInteger[] fields;

    public DMK() {
        fields = new SlidingInteger[7];
        fields[FIELD_M] = new SlidingInteger(5);
        fields[FIELD_D] = new SlidingInteger(5);
        fields[FIELD_C] = new SlidingInteger(1);
        fields[FIELD_I] = new SlidingInteger(5);
        fields[FIELD_IP] = new SlidingInteger(10);
        fields[FIELD_MJ] = new SlidingInteger(1);
        fields[FIELD_PLACEHOLDER1] = new SlidingInteger(1);
    }

    public int getM() {
        return fields[FIELD_M].getIntValue();
    }

    public int setM(int newVal) {
        fields[FIELD_M].setIntValue(newVal);
    }

    public int getD() {
        return fields[FIELD_D].getIntValue();
    }

    public int setD(int newVal) {
        fields[FIELD_D].setIntValue(newVal);
    }
}