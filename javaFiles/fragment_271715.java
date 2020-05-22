Kreis[] kreisRot = new Kreis[6];
Kreis[] kreisBlau = new Kreis[6];

void setup() {
  size(600, 600);

    for (int r=0; r < kreisRot.length; r++) {
        kreisRot[r] = new Kreis(50+r*100, 50, 255, 0, 0);
    }

    for (int b=0; b < kreisRot.length; b++) {
        kreisBlau[b] = new Kreis(50+b*100, height-50, 0, 0, 255);
    }
}