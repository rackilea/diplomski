void draw() {

    boolean hit = false;
    for (int i = 0; hit == false && i < fall.length; i+=3) {
        hit = hit || fall[i].intersect(direction1, 450, heightWidth, heightWidth);
    }

    if ( hit )
        background(255, 0, 0);
    else
        background(0); 

    // .....

}