public class Tile {
    final int xPos,yPos;
    private String type;
    List<Entity> entities = new ArrayList<>();
    public Tile(int xPosition, int yPosition) {
        xPos = xPosition;
        yPos = yPosition;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void addEntity(Entity e){
        entities.add(e);
    }
    public void removeEntity(Entity e){
        entities.remove(e);
    }
}