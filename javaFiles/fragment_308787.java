public class Demo {
    enum Color {
        WHITE, BLACK;
    }

    public static void main(String[] args) {
        Color color = null;

        switch (color) {    // NPE here
        case WHITE: break;
        case BLACK: break;
        default: break;     // null value does not fall into the default
        }
    }
}