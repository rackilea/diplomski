float a = 255 - map(closestDistance, 0, 112, 0, 255); //Map variable 'a' as alpha based on distance. E.g. if distance is high, d = 100, alpha is low, a = 255 - 225 = 30.

if (closestDistance<112) {
  noStroke(); //No outline.
  fill(0, a); //Particle are coloured black, 'a' to vary alpha.
  ellipse(location.x, location.y, 8, 8); //Draw ellipse based on location of particle.
} else {
  noStroke(); //No outline.
  fill(0, 30); //For particles far away, set them to a fix alpha of '30'
  ellipse(location.x, location.y, 8, 8); //Draw ellipse based on location of particle.
}