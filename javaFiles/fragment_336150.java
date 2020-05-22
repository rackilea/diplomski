class Meteor {

    // .....

    boolean intersect(float rx, float ry, float rw, float rh) {
        return  
            (x + ellipseSizeone/2.0f) > rx &&
            (rx + rw) > (x - ellipseSizeone/2.0f) &&
            (y + ellipseSizetwo/2.0f) > ry &&
            (ry + rh) > (y - ellipseSizetwo/2.0f);
    }
}