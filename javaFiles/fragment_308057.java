boolean hasNotLost(GRect ufo_ship){ return ufo_ship.getY() < 200; }

while(hasNotLost(ufo_ship))
{
  ...
}