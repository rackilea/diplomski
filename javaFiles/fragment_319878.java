public void update() {

    setBounds(getX(), getY(), getWidth(), getHeight()); //I kept this from your code, but I don't actually know what it does

    float dx = player.getX() - getX(); //note: I removed abs
    float dy = player.getY() - getY();

    float norm = Math.sqrt(dx*dx + dy*dy);

    //normalization:
    float wx = dx/norm;
    float wy = dy/norm;

    for (obstacle o : obstacles) { //assuming obstacles is an iterable datastructure containing instances of the class obstacle
         //note, it suffices to iterate over close by obstacles
         dx = getX() - o.getX();
         dy = getY() - o.getY();

         norm = Math.sqrt(dx*dx + dy*dy);

         //normalization:
         float ox = dx/norm;
         float oy = dy/norm;

         //add scaling to get the repulsion force we want
         wx += ox/norm;
         wy += oy/norm;
    } 

    float norm_of_w = Math.sqrt(wx*wx + wy*wy);
    float vx = speed * wx / norm_of_w;
    float vy = speed * wy / norm_of_w;

    setX(getX() + vx);
    setY(getY() + vy);
}