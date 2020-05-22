double x = (distance - range1) / (range2 - range1);
if (x < 0)
  x = 0;
if (x > 1)
  x = 1;
return damage1 + x * (damage2 - damage1);