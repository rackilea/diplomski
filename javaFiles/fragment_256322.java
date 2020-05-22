public static float getAngle(Point source, Point destination) {
  System.out.println(source + "\n" + destination);
  double xDiff = source.x - destination.x;
  double yDiff = source.y - destination.y;
  System.out.println((float) Math.toDegrees(Math.atan2(yDiff, xDiff)));
  return (float) Math.toDegrees(Math.atan2(yDiff, xDiff)) + 90.0F;
}