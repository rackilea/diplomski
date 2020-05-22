public static Color[] possibleColors = { Color.RED, Color.green, Color.blue, Color.yellow, Color.PINK, Color.BLACK };
public static List<Color> colorList = Arrays.asList(possibleColors);

public static List<Color> getRandomColorList() {
    Collections.shuffle(colorList);
    return colorList.subList(0, 4);
}