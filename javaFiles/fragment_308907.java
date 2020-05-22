void move() {
  //Red square movement
  // You only need to check for input once, then for which input interests you
  if (keyPressed) {
    // I think this would look better in a switch statement, but we'll keep it an If for simplicity
    if (key == 'd' || key == 'D') {
      // checking if the square will collide BEFORE it does
      // notice that the square won't move if it detects that this move will be a collision
      if (!rectRect(rx + speed, ry, rw, rh, bx, by, bw, bh)) {
        rx = rx + speed;
      }
    }
    else if (key == 'a' || key == 'A') {
      if (!rectRect(rx - speed, ry, rw, rh, bx, by, bw, bh)) {
        rx = rx - speed;
      }
    }
    else if (key == 'w' || key == 'W') {
      if (!rectRect(rx, ry - speed, rw, rh, bx, by, bw, bh)) {
        ry = ry - speed;
      }
    }
    else if (key == 's' || key == 'S') {
      if (!rectRect(rx, ry + speed, rw, rh, bx, by, bw, bh)) {
        ry = ry + speed;
      }
    }

    if (ry > width) {
      // insert whatever you were planning with this condition
    }
  }
}