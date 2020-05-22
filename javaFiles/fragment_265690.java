class Game{
    List<Entity> entities;

    //your "act" method
    public void update(){
        for(Entity e : entities){
            e.update();
        }
    }
    public void draw(Graphics2D g){
        for(Entity e : entities){
            e.draw(g);
        }
    }
}