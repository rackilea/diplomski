public void loadSavedGame(File loadfile) {

    List<Integer> allCells = getCells(loadfile);
    setMineGame(allCells.size());
    int index = 0;

    for(Integer value : allCells){
        mineGame.setCell(index, value);
        index++;
    }

    mineGame.repaint();
    tp.setSelectedIndex(0);
}