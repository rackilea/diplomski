Coordinate newCoord = new Coordinate(0,0);

    for(int i = 0; i < 96; i++)
    {
        j = j + 5;

        newCoord.setX(j);
        newCoord.setY((int)(Math.random()*300));

        mOrigCoords.add(newCoord);
    }