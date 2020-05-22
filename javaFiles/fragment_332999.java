enum Type {

    MPEG2(2), PASSED_PIDS_ID(3), DVB(4), ATSC(5), NA(6), UNDETERMINED(7);

    private final int value;

    Type(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}