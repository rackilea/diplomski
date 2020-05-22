float x = 0.0, y= 0.0;

void setup() {
    size(300, 300);
    x = (float)random(width);
    y = (float)random(height);
}

void draw() {
    float speed = 3;

    /*
    //setup points
    PVector Pt = new PVector(x, y);
    PVector Pm = new PVector(mouseX, mouseY);

    // calcualte normalized direction
    PVector D = PVector.sub(Pm, Pt);
    D.normalize();

    // calcualte new point
    float movelen = min(PVector.dist(Pt, Pm), speed);
    PVector newPt = PVector.add(Pt, D.mult(movelen));
    x = newPt.x;
    y = newPt.y;
    */

    float dx = mouseX - x;
    float dy = mouseY - y;
    float dist = sqrt(dx*dx + dy*dy);
    if (dist > 0) {
        float movelen = min(dist, speed);
        x += dx/dist * movelen;
        y += dy/dist * movelen;
    }

    background(196);
    stroke(0);
    fill(255, 0, 0);
    ellipse((int)x, (int)y, 10, 10);
    fill(0, 255, 0);
    ellipse(mouseX, mouseY, 10, 10);
}