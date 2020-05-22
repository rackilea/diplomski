public class MenuScreen
{
    private Game gameObject;
    public MenuScreen(Game gameObject)
    {
        this.gameObject = gameObject;
    }
    private void someMethod()
    {
         //Switches to a new MenuScreen... 
         //useless in most cases but you get the idea
         gameObject.setScreen(new MenuScreen(gameObject);
    }
}