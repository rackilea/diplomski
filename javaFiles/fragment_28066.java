double radAngle;
if (x_dist == 0) {
  radAngle = 90;
} else if ((x_dist == 0) && (y_dist == 0)) {
  radAngle = 0;
} else {
  radAngle = Math.atan(y_dist / x_dist);
}