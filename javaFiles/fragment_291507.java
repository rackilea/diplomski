public static String getColorAsName(MyCircle circle) {
    String colorName = null;
    if (circle.getColor().equals(Color.BLACK)) {
        colorName = "BLACK";
    } else if(circle.getColor().equals(Color.RED)) {
        colorName = "RED";
    }
    ...

    return colorName;
}