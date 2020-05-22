class Gradient {
    public final Color start;
    public final Color end;

    protected void blendTo(Color c1, Color c2, double BlendStart,
            double blendEnd) {
        // method to draw gradient blend
    }

    public Gradient(Color start, Color end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("No parameters can be null.");
        }

        this.start = start;
        this.end = end;

        blendTo(this.start, this.end, 0.0, 1.0);
    }
}

class ThreeGradient extends Gradient {
    public final Color middle;

    // This is invalid Java code
    public ThreeGradient(Color start, Color end, Color middle) {
        this.middle = middle;

        blendTo(this.start, this.middle, 0.0, 0.5); // If this were valid, it
                                                    // would attempt to use
        blendTo(this.middle, this.end, 0.5, 1.0);   // this.start and this.end
                                                    // before initialization.
        super(start, end);
    }
}