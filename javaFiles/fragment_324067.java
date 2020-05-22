public Rectangle(Position position, float width, float height) // Changed types to float
{
    super((int) width, (int) height); // Cast from float to int
    this.position = position;

    // width & height are floats, like requested
}