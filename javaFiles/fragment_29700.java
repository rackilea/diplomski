public class Main extends PApplet
{
  ...

  int currentColor = gray;

  public Main(){}

  ...

  public void draw()
    {
        if( i % 11 == 0 )
           currentColor = green;
        else if( i % 13 == 0 )
           currentColor = blue;
        else if( i % 17 == 0 )
           currentColor = pink;
        else {
           // Use current color
        } 

        fill(currentColor);

        ...
}