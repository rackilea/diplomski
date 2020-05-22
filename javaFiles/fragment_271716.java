void draw() {
    for (int r=0; r < kreisRot.length; r++) {
        kreisRot[r].show();
     }

    for (int b=0; b < kreisBlau.length; b++) {
        kreisBlau[b].show();
    }

    for (int r=0; r < kreisRot.length; r++) {
        for (int b=0; b < kreisBlau.length; b++) {
            stroke(0, 196, 0);
            strokeWeight(3);
            line(kreisRot[r].X(), kreisRot[r].Y(), kreisBlau[b].X(), kreisBlau[b].Y());
        }
    }
}