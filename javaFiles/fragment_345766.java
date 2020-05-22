public class Player extends GameObject {

    private Handler handler;
    public float rotation = 0;

    public Player(int x, int y, ID id, Handler handler) {//, HUD hud) {
        super(x, y, id);
        this.handler = handler;

    }

    @Override
    public void update() {
        if (handler.is(InputAction.UP)) {
            setVelY(-5);
        } else if (handler.is(InputAction.DOWN)) {
            setVelY(5);
        } else {
            setVelY(0);
        }

        if (handler.is(InputAction.LEFT)) {
            setVelX(-5);
        } else if (handler.is(InputAction.RIGHT)) {
            setVelX(5);
        } else {
            setVelX(0);
        }

        if (handler.is(InputAction.ROTATE)) {
            rotation += 0.1;
        }
    }

    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 38);
        y = Game.clamp(y, 0, Game.HEIGHT - 67);

        collision();

    }

    public void render(Graphics g) {
        //g.setColor(Color.WHITE);      
        //g.fillRect(x, y, 32, 32);
        Graphics2D g2d = (Graphics2D) g.create();
        Rectangle r = new Rectangle(0, 0, 32, 32);
        Path2D.Double path = new Path2D.Double();
        path.append(r, false);

        AffineTransform t = new AffineTransform();
        t.translate(x, y);
        t.rotate(rotation, 16, 16);
        path.transform(t);
        g2d.setColor(Color.WHITE);
        g2d.draw(path);
        g2d.dispose();

    }

    public void collision() {

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

//              if (tempObject.getId() == ID.BasicEnemy) {
//                  if (getBounds().intersects(tempObject.getBounds())) {
//                      hud.HEALTH -= 2;
//                  }
//              }
        }

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

}