void draw() {

    boolean hit = false;
    for (int i = 0; hit == false && i < fall.length; i+=3) {
        hit = hit || fall[i].intersect(direction1, 450, heightWidth, heightWidth);
    }

    if ( hit )
        background(255, 0, 0);
    else
        background(0); 

    rect(direction1, 450, heightWidth, heightWidth);
    fill(0,20);
    rect(0,0,800,500);

    direction1+=speedX;
    if (direction1 > width-bounceSize) {
        direction1 = width-bounceSize;
        speedX = -12;
    }
    if (direction1 < 0) {
        direction1 = 0;
        speedX = 12;
    }

    for (int i = 0; i < fall.length; i+=3) {
        fall[i].fall();
    }
    fill(0,255,0);
}