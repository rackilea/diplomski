public boolean checkCircleCollision(float x1, float y1, float r1,
    float x2, float y2, float r2) {
  if (Math.sqrt(((x2 - x1) ^ 2) + ((y2 - y1) ^ 2)) <= (r1 + r2)){
    return true;
  } else {
    return false;
  }
}