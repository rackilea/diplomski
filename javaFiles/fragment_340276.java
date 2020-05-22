public void move(){
        if (x < 0) {   // left bound
            dx = -dx;  // now move right, same speed
            x=-x;      // bounce inside
        }
        if (y < 0){    // upper bound
            dy = -dy;  // now move down, same speed
            y=-y;      // bounce inside
        }
        if (x > 600){      // right bound
            dx = -dy;      // now move left, same speed
            x=600-(x-600); // bounce inside
        }
        if (y >500){       // lower bound
            dy = -dy;      // now move up, same speed
            y=500-(y-500); // bounce inside
        }
        x += dx;
        y += dy;
    }