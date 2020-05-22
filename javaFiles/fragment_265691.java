class Game{
    private List<Entity> entities;
    private int time = 0;        

    //your "act" method
    public void update(){
        for(Entity e : entities){
            e.update(time);
        }
        time++;
    }
    public void draw(Graphics2D g){
        for(Entity e : entities){
            e.draw(g);
        }
    }
}