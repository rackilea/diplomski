class Meteor {
    float x = random(800);
    float y = random(-500);

    void fall() {
        fill(random(200),0,0);
        ellipse(x, y, ellipseSizeone, ellipseSizetwo);

        y = y + 3; 
        if(y>height){
            x = random(800);
            y = 0;
        }
    }

    boolean intersect(float rx, float ry, float rw, float rh) {
        return  
            (x + ellipseSizeone/2.0f) > rx &&
            (rx + rw) > (x - ellipseSizeone/2.0f) &&
            (y + ellipseSizetwo/2.0f) > ry &&
            (ry + rh) > (y - ellipseSizetwo/2.0f);
    }
}