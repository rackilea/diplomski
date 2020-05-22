public void move() {

    if(x > -16) {
        x -= move_speed;
    } else {
        ObjectHandler.remember_to_kill(this);
    }

}

// in ObjectHandler:

private HashSet<type_of_object_to_kill> kill_memory = new...;

public void remember_to_kill() {
    this.kill_memory.add(this);
}

private void kill_from_memory() {
    for (type_of_object_to_kill obj: kill_memory) {
        ObjectHandler.bullets.remove(this);
    }
    ObjectHandler.kill_memory.clear();
}

// update movement:

public void updateMovement() {
    PlayerObject.update();

    for(Bullet bullet : ObjectHandler.bullets) {
        bullet.move();
    }
    ObjectHandler.kill_from_memory();
}