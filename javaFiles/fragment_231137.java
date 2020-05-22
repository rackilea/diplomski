public abstract class BaseScreen implements Screen, InputProcessor
{
     public BaseScreen() 
     {
         windowWidth = Gdx.graphics.getWidth();
         windowHeight = Gdx.graphics.getHeight();
         AudioManager.getScreenThemes().put(this, getScreenMusic());
     }

     public void pause()
     {
         AudioManager.pause();
     }

     public void resume()
     {
         AudioManager.play();
     }

     public void show()
     {
         Gdx.input.setInputProcessor(this);
         AudioManager.switchMusic(this);
     }


     public abstract Music getScreenMusic();
     ...
}