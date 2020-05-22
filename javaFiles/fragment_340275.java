public void move(){
        if (x < 0) { // left bound
            dx = 1;  // now move right
        }
        if (y < 0){  // upper bound
            dy = 1;  // now move down
        }
        if (x > 600){// right bound
            dx = -1; // now move left
        }
        if (y >500){ // lower bound
            dy = -1; // now move up
        }
        x += dx;
        y += dy;
    }