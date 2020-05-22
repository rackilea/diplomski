class Planet {
    public static MERCURY = new Planet(3.303e+23, 2.4397e6);
    public static VENUS = new Planet(4.869e+24, 6.0518e6);
    public static EARTH = new Planet(5.976e+24, 6.37814e6);
    public static MARS = new Planet(6.421e+23, 3.3972e6);
    public static JUPITER = new Planet(1.9e+27, 7.1492e7);
    public static SATURN = new Planet(5.688e+26, 6.0268e7);
    public static URANUS = new Planet(8.686e+25, 2.5559e7);
    public static NEPTUNE = new Planet(1.024e+26, 2.4746e7);

    private mass: number;
    private radius: number;

    private constructor(mass: number, radius: number) {
        this.mass = mass;
        this.radius = radius;
    }

    public static G = 6.67300E-11;

    public surfaceGravity(): number {
        return Planet.G * this.mass / (this.radius * this.radius);
    }

    public surfaceWeight(otherMass: number) {
        return otherMass * this.surfaceGravity();
    }
}

console.log(Planet.MERCURY.surfaceGravity());