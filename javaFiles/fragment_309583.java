public class Bullet
{
    public static float VELOCITY;
    private Vector2f position;

    public Bullet(float x, float y, float velocity)
    {
        position = new Vector2f(x, y);

        VELOCITY = velocity;
    }

    public void update(float delta, boolean vertical)
    {
        if(vertical)
        {
            y += VELOCITY * delta;
        }
        else
        {
            x += VELOCITY * delta;
        }
    }
}