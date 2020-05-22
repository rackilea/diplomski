dmg++;
DamageOutput.setText(String.valueOf(dmg));
if ((dmg % 10) == 0) {
    epoints++;
    EvoPoints.setText("Points: " + String.valueOf(epoints));
}