private long fired = 0L;

public void update() {
   ...
   // firing missiles: only if the missile count is less than the max., and the elapsed
   // time is more than a limit (100 ms)
   if ( isShooting && missiles.size() < missilesCount &&
        ( System.currentTimeMilis() - this.fired ) > 100 ) {
      missiles.add( new Missile( player.getX() + 16, player.getY() + 16 ) );
      // time of last firing
      this.fired = System.currentTimeMilis();
   }
   ...
}

public void RemoveMissile(Missile e) {
   // as Guest is asked in another answer, this method should remove, not add...
   missiles.remove(e);
}