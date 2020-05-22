Iterator<Plane> i = planes.iterator();

while (i.hasNext()) {
  Plane p = i.next();

  if (p.getX() < -50) {
    i.remove();
  } else {
    p.onDraw(c);

    if (p.getX() < 170) {
      detectPlaneCollision(p, c);
    }
  }
}