public class ChipSet {

    public static final int WHITE_VALUE = 1;
    public static final int RED_VALUE = 2;
    public static final int GREEN_VALUE = 5;
    public static final int BLUE_VALUE = 10;
    public static final int BLACK_VALUE = 20;

    public static final int[] VALUES = new int[]{WHITE_VALUE, RED_VALUE, GREEN_VALUE, BLUE_VALUE, BLACK_VALUE};

    protected int[] chips;

    public ChipSet(int[] chips) {
        if (chips == null || chips.length != 5) {
            throw new IllegalArgumentException("ChipSets should contain exactly 5 integers!");
        }

        // store a copy of passed array
        this.chips = new int[5];
        for (int i = 0; i < this.chips.length; i++) {
            this.chips[i] = chips[i];
        }
    }

    public int getSum() {
        return chips[0] * WHITE_VALUE
                + chips[1] * RED_VALUE
                + chips[2] * GREEN_VALUE
                + chips[3] * BLUE_VALUE
                + chips[4] * BLACK_VALUE;
    }

    public int[] getChips() {
        return this.chips;
    }
}