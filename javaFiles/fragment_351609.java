public static Color colorOf(String color) {
    try {
        return (Color) Color.class.getDeclaredField(color).get(null);
    } catch(Exception notAvailable) {
        return null; // ??
    }
}