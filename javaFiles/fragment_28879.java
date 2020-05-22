public int manhattanDistance(Point other){ //not sure why return an int...I think returning a double makes more sense..
    int xdist = Math.abs(this.x-other.x);
    int ydist = Math.abs(this.y-other.y);
    return (int)xdist+ydist; //cast to int because you must return int

}