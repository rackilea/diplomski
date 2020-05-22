private int pos;
public Projectile (double x, double y, Handler handler){
    this.x = x;
    this.y = y;
    this.pos = Player.getPos();
}