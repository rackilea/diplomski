//Initialize your cellMap else where first
ICellEntity[][] cellMap = new CellEntity[width][length];
for(int x=0; x<width; x++)
    for(int y=0; y<length; y++)
        cellMap[x][y] = new CellEntity();

//Pass in the initialized cellMap via the constructor
MapEntity mapEntity = new MapEntity(cellMap);