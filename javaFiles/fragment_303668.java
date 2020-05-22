public class Batman extends CombatEntity{

    //Default constructor with no parameters 
    public Batman(){
        super("", null);
    }

    public Batman(String name, BufferedImage sprite){
        super(name, sprite);
    }

    public void generateSpriteImage(String spriteImagePath) {
        try {
            File file = new File(spriteImagePath);
            this.sprite = ImageIO.read(file);
        }

        catch(Exception e) {
            //whatever
        }
   }
}