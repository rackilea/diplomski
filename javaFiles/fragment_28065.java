double radAngle;
if (x_dist == 0) {
  radAngle = 90;
} else if (y_dist == 0) {
  radAngle = 90;
} else {
  radAngle = Math.atan(y_dist / x_dist);
}