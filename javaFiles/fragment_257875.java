void pipeMove() {

    if (movingToA) {

      xpos = xpos + xspeed;

      if (xpos > 100) {
        xpos = 100;
        movingToA = false;
        waitingAtA = true;
        time = millis();
      }
    } else if (waitingAtA) {
      if (millis() > time + 5000) {
        waitingAtA = false;
        movingToB = true;
      }
    } else if (movingToB) {
      xpos = xpos + xspeed;

      if (xpos > 200) {
        xpos = 200;
        movingToB = false;
      }
    }
  }
}