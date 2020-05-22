public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
     private final Persistence persistence = new Persistence(getContext());

     @Override
     public void surfaceCreated(SurfaceHolder holder) {
        //we can safely start the game loop
        persistence.getData(player);


}