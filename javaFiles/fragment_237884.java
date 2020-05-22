public class BulletController {

    private LinkedList<Bullet> b = new LinkedList<>();

    Bullet tempBullet;
    Context context;
    //ImageView ship;
    float x;
    float y;
    public BulletController(Context context) {
        this.context = context;
        this.x = x;
        this.y = y;
        addBullet(new Bullet(x, y, context));
    }

    public void tick() {
        for(int i = 0; i < b.size(); i++) {
            tempBullet = b.get(i);
            tempBullet.tick();
        }
    }
    public void render(Canvas canvas) {
        for(int i = 0; i < b.size(); i++) {
            tempBullet = b.get(i);
            tempBullet.render(canvas);
        }
    }
    public void addBullet(Bullet bullet) {
        b.add(bullet);
    }
    public void removeBullet(Bullet bullet) {
        b.remove(bullet);
    }
}