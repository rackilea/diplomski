class Planet {
    public static MERCURY = new Planet(3.303e+23, 2.4397e6);
    public static VENUS = new Planet(4.869e+24, 6.0518e6);
    ...

    private static VALUES: Planet[] = [];

    private mass: number;
    private radius: number;

    private constructor(mass: number, radius: number) {
        this.mass = mass;
        this.radius = radius;

        Planet.VALUES.push(this);
    }

    public static values() {
        return Planet.VALUES;
    }

    ...
}