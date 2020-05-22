public enum Month {
    January, February, March, April, May, June, July, August, September, October, November, December;

    public static Month getDefault() {
        return January;
    }

    public static Month fromNumber(int monthNumber) {
        try {
            return Month.values()[monthNumber-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return getDefault();
        }
    }

    public static Month fromString(String nameOfMonth) {
        try {
            return valueOf(nameOfMonth);
        } catch (IllegalArgumentException e) {
            return getDefault();
        }            
    }
}