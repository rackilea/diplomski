public class Vector3
{
    private final double x;
    private final double y;
    private final double z;

    public Vector3(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 plus(Vector3 other)
    {
        return new Vector3(x + other.x, y + other.y, z + other.z);
    }

    // etc
}