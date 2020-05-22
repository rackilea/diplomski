public enum CellData {

    HIGH("High", Color.GREEN),
    MEDIUM("Medium", Color.YELLOW),
    LOW("Low", Color.RED),
    NONE("None", Color.BLUEVIOLET);

    private String data;
    private Color color;

    CellData(String data, Color color) {
        this.data = data;
        this.color = color;
    }

    public static CellData cellData(String data) {
        return Arrays.stream(values())
                    .filter(e -> e.data.equals(data))
                    .findAny()
                    .orElse(NONE);
    }

    public Color getColor() {
        return color;
    }
}