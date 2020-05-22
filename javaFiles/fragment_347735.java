void loadFile() {
    try (final ObjectInputStream is = new ObjectInputStream(new FileInputStream("savestate.dat"))) {
        playingField = (EnhancedMinesweeperTile[][]) is.readObject();
    } catch (ClassNotFoundException | IOException e1) {
        e1.printStackTrace();
    }
}