public Shot(World world, Camera camera, Vector2 pos, int width, int height, Color color, Vector2 target) {
    super(world, camera, pos, width, height, color);
    this.target = target

    //dx = targetX - x; get rid of this
    //dy = targetY - y; and this

//add a vector called direction

this.direction = (target - pos).Normalize();
}

@Override
public void update(GameContainer gc, int delta) {

pos += direction * delta * bulletSpeed;
}