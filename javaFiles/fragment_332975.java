public class MyGame extends Game
{
  public void create()
  {
    Assets assets = new Assets();
    assets.manager.load(); //starts loading assets

    //option 1
    assets.manager.finishLoading(); //Continues when done loading.
    //it won't continue until all assets are finished loading.
  }

  //option 2
public void update()
  {
    //draw something nice to look at
    if (manager.update())
    {
      //Assets have finished loading, change screen maybe?
      setScreen(new MenuScreen(assets)); //your screen should take a Assets object in it's constructor.
    }
  }  
}