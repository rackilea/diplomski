public class CombatEntity {

    protected String name;

    protected BufferedImage sprite; 

    public CombatEntity(String name, BufferedImage sprite) {
        this.name = name;
        this.sprite = sprite;
    }

    /*
     * Getters and Setters 
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }   
}