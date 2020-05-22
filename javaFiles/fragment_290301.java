// Initialize static properties as they're declared.
public static ColorSensor colourSensor = new ColorSensor(SensorPort.S2);

// Or initialize in a static initialization block to do them all at once.
public static TouchSensor touchSensor;
// ... and the others.
static {
    touchSensor = new TouchSensor(SensorPort.S4);
    // ... and the others.
}