public boolean checkCollision(View ball)
{
    boolean result = false;

    for(Stick stick : Stick.getStickList())
    {
         if(collision(ball, stick))
         {
             result = true;
             break;
         }
         else result = false;
     }

    return result;
}

/*Gets View HitRect*/
public boolean collision(View a, View b)
{
   Rect aRect = new Rect();
   a.getHitRect(aRect);
   Rect bRect = new Rect();
   b.getHitRect(bRect);
   return aRect.intersect(bRect);
}