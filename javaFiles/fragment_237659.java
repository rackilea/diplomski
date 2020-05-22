Particle closestNeighbor = null;
float closestDistance = 100000;

for (Particle other : p) { //For every particle in the ArrayList.

  if (other == this) {
    continue;
  }


  float d = PVector.dist(location, other.location);
  if (d < closestDistance) {
    closestDistance = d;
    closestNeighbor = other;
  }
}