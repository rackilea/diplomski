public class Game extends Group {

    Entity ship;
    long delta;
    HashSet<String> input = new HashSet<>();

    public Game() {
        File f = new File("src/ressources/ship.gif");
        ship = new Entity(new Image("file:///" + f.getAbsolutePath().replace("\\", "/")) ,300, 300);
        getChildren().add(ship);



        new AnimationTimer(){
            @Override
            public void handle(long now) {
                if(input.contains("LEFT"))
                    ship.setVelX(-1);
                if(input.contains("RIGHT"))
                    ship.setVelX(1);

                ship.move(now);
                getChildren().clear();
                getChildren().add(ship);
            }
        }.start();
    } 

    public void keyDown(String key) {
        if(!input.contains(key))
            input.add(key);    
    }

    public void keyUp(String key) {
        input.remove(code);
    }
}