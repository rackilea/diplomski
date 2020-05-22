//Let the class extend from game
public class MyGame extends Game()
{
    //Delete everything in it and leave a create() with a single line
    @Override
    public void create() {
    setScreen(new MenuScreen());
    }
}