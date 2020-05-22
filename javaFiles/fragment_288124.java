Explosion explosion = new Explosion(context);
explosion.play();

class Explosion{
    Context context;

    public Explosion(Context context){
        this.context = context;
    }

    public void play(){
       MediaPlayer mp = MediaPlayer.create(context, R.raw.explosionsound);
       mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

           @Override
           public void onCompletion(MediaPlayer mp) {
               mp.stop();
               mp.release();
           }
       });
       mp.start();
    }
}