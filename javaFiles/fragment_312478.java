phi   = 2.0 * PI * getRanNumberDouble(0.0, 1.0);
csth  = 2.0 * getRanNumberDouble(0.0, 1.0) - 1.0;
snth  = sqrt((1.0 - csth)*(1.0 + csth));
wx = snth * sin(phi);
wy = snth * cos(phi);
wz = csth;