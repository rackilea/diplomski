public void SaveGame() throws IOException {

    PnlCentro pnlCentro = new PnlCentro();

    /* Set data prior to writing out */
    pnlCentro.setLives(getThisGamesNumLives());
    pnlCentro.setTime(getThisGamesTime());

    FileOutputStream fileOut = new FileOutputStream(fileName);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(pnlCentro);
    out.close();
}