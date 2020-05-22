@Override
public void received(Connection connection, Object data) {
   super.received(connection, data);
   nb++;
   if (nb == 5) {
      final MyGdxGame g = MyGdxGame.this;
      Gdx.app.postRunnable(new Runnable() {
         public void run() {
            g.setSecondScreen();
         });
   }
}