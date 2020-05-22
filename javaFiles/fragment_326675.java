public Map (Name mapName){
        sector = new Sector[X][Y];
        for (int i=0; i < X; i++){
            for (int j=0; j<Y; j++) {
                sector[i][j] = new Sector (i,j);
            }
        }
        Matrix = new int[23][14];
        if(mapName==Name.FERMI){
            sector[10][8]=new Alien(10,8);
            sector[10][9]=new Human(10,9);
        }
        if(mapName==Name.GALILEI||mapName==Name.GALVANI){
            sector[10][5]=new Alien(10,5);
            sector[10][7]=new Human(10,7);
        }
        ...
}