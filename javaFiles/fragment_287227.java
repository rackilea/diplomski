dmg+= 1+intUnit1; //Deal more damage with more units
DamageOutput.setText(String.valueOf(dmg));
int newEPoints = dmg/10 - spentEPoints;
if(epoints != newEPoints) {
    EvoPoints.setText("Points: " + String.valueOf(newEPoints));
}
epoints = newEPoints;