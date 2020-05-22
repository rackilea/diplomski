public class Player {
   private List<Bullet> firedBullets = new ArrayList<Bullet>();

   public void fire(){
       Bullet bullet = new Bullet(playerX, playerY);
       firedbullets.add(bullet);
       bullet.launch(direction); //this should be calculated by which direction the player is facing.
   }
}