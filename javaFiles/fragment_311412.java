public class ExampleObject extends GridObject { 
  private static final String name = "Example Object"; 
  private static Bitmap skin;
  // = BitmapFactory.decodeResource(c.getResources(), R.drawable.defaultObject );
  private static float x,y; 

  public ExampleObject(Context c, float x, float y) { 
    synchronized(ExampleObject.class) {
      if(skin == null) {
        skin = BitmapFactory.decodeResource(c.getResources(), R.drawable.defaultObject);
      }
    }
    this.x = x; 
    this.y = y; 
  }
}