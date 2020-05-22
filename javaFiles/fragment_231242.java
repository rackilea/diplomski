Coordinate newCoord = null;

for(int i = 0; i < 96; i++)
{
    newCoord = new Coordinate(0,0);
    j = j + 5;

    newCoord.setX(j);
    newCoord.setY((int)(Math.random()*300));

    mOrigCoords.add(newCoord);
}