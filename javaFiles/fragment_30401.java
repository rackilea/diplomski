public class ResourceSingleton {
    private Map<String, Sprite> sprites = new HashMap<>();
    private Map<String, BufferedImage> images = new HashMap<>();
    private <String, Clip> sounds = new HashMap<>();
    private <String, Font> fonts = new HashMap<>();     

    public Map getSprites()
    {return sprites;}

    public void setSprites(Map<String,Sprite> sprites)
    { this.sprites = sprites; } 

    //generate other getter setter

    // Private constructor prevents instantiation from other classes
    private ResourceSingleton() { }


    private static class SingletonHolder { 
            public static final Singleton instance = new Singleton();
            //populate your resource here.
    }

    public static ResourceSingleton getInstance() {
            return SingletonHolder.instance;
    }