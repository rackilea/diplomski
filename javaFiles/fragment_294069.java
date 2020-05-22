public class Color {

    public int  R, G, B, A;

    // base ctr
    public Color(int R, int G, int B, int A) {
        this.R = R;
        this.G = G;
        this.B = B;
        this.A = A;
    }

    // base, default alpha=255 (opaque) 
    public Color(int R, int G, int B) {
        this(R, G, B, 255);
    }

    // ctr from double values
    public Color(double R, double G, double B, double A) {
        this((int) (R * 255), (int) (G * 255), (int) (B * 255), (int) (A * 255));
    }

    // copy ctr
    public Color(Color c) {
        this(c.R, c.G, c.B, c.A);
    }

}