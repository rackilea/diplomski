private void calculateVelocity(float x, float y, float z){
    long now = System.currentTimeMillis();
    interval = (now - lastEvent);
    if(interval > 100){
        lastEvent = now;
        double acceleration = x+y+z-lastX-lastY-lastZ;
        double velocity = v0 + (acceleration*(interval/(double)1000));
        velocities.add(Math.abs(velocity));
        v0= velocity;
        lastX = x;
        lastY = y;
        lastZ = z;
    }
}