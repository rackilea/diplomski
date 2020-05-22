public class DataModel {
    private final int number;
    private final int colorNumber;

    private final Color backgroundColor;
    private final Color foregroundColor;

    public DataModel(int number, int colorNumber, Color backgroundColor,
            Color foregroundColor) {
        this.number = number;
        this.colorNumber = colorNumber;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    public int getNumber() {
        return number;
    }

    public int getColorNumber() {
        return colorNumber;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

}