public enum Color {
    Undefined (0), Red(1), Yellow(2), Blue(3), Green(4), Black(5);
    private int mValue;
    Color(int value) { this.mValue = value;} // Constructor
    public int id(){return mValue;}                  // Return enum index

    public static Color fromId(int value) {
        for(Color color : values()) {
            if (color.mValue == value) {
                return color;
            }
        }
        return Undefined;
    }
}