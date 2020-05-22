public static void main(String[] args) {
    Square square = new Square(0, 0, 10, 10);

    // Without the generic it's necessary to cast the return value
    square = (Square) shrink(square);

    // Cast not needed with generic
    square = shrinkWithGenerics(square);
}

public static Polygon shrink(Polygon poly) {
    // ...
}

public static <T extends Polygon> T shrinkWithGenerics(T poly) {
    // ...
}