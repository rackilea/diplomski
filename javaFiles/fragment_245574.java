public void shiftMap(){
    for(int i = tMap.getCurrentX(); i < tMap.getCurrentRows(); i++){
        for (int j = tMap.getCurrentY(); j < tMap.getCurrentCols(); j++) {
            tMap.getCurrentMap()[i][j] = tMap.getMap()[i][j+1];
        }
    }
}