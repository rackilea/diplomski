public class Circle extends Shape {
    public final int radius; // Immutable - no getter needed

    @JsonCreator
    public Circle(@JsonProperty("radius") int radius) {
        this.radius = radius;
    }
}

public class Rectangle extends Shape {
    public final int w; // Immutable - no getter needed
    public final int h; // Immutable - no getter needed

    @JsonCreator        
    public Rectangle(@JsonProperty("w") int w, @JsonProperty("h") int h) {
        this.w = w;
        this.h = h;
    }
}