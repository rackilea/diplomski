void draw() {

    // "fade" the entire view 
    blendMode(DIFFERENCE);
    fill(1, 1, 1, 255);
    rect(0, 0, width, height);

    blendMode(ADD);

    // create PShape object
    aux = createShape();
    aux.beginShape();
    aux.stroke(255);
    aux.strokeWeight(0.5);
    aux.noFill();
    for (float x = 0; x < width + xInc; x = x + xInc) {
      float noise = noise(x / 150, noise_y) ;
      // get the actual y coordinate
      float y = map(noise, 0, 1, height / 2, 0);
      // create vertex of shape at x, y
      aux.vertex(x, y);
    }
    aux.endShape();

    // push the current one in the history
    int currentIndex = lastIndex; 
    history[lastIndex++] = aux;
    if (lastIndex == arrLen)
      lastIndex = 0;

    // draw the newes shape
    shape(history[currentIndex]);

    noise_y = noise_y - noise_increment;
    println(frameRate, full ? arrLen : lastIndex);
}