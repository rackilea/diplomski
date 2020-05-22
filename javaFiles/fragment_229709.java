public void update(float delta) {
    if (pos.x > Kiwi.WIDTH / 2)
        vel.add(5*delta, 0, 0); // Acceleration is now 5 px/s^2 to the right
    vel.x -= vel.x*0.2f*delta; // Decay speed by 20% every second
    pos.add(vel.x*delta, 0, 0); // Move position by speed.
}