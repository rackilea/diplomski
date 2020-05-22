public enum Color {

    DOT_BLUE, DOT_YELLOW, SQUARE_BLUE, SQUARE_YELLOW;

    public static void main(String[] args) {
        Color color = Color.valueOf("DOT_BLUE");
        System.out.println(color.equals(Color.DOT_BLUE));
        System.out.println(color);
    }

}