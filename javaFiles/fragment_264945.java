public class ColorScheme {

    public enum Color {DARK_BLACK,
                       WHITE}

    private Color Scheme;

    public ColorScheme() {
        this.Scheme     =   Color.DARK_BLACK;
    }

    public ColorScheme(Color SchemeType) {
        this.Scheme     =   SchemeType;
    }
}