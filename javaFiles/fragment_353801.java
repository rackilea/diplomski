public class Entity
{
     public abstract Bitmap getSprite();

     public void draw(Canvas canvas, int x, int y)
     {
          canvas.drawBitmap(getSprite(), x, y, null);
     }
}

public class Marine extends Entity
{
    public Bitmap getSprite() {
        return /*the sprite*/;
    }
}