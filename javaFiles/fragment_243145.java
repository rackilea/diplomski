public void SaveGame() throws IOException {

    PnlCentro pnlCentro = new PnlCentro(); //<-- Problem likely lies here!

    FileOutputStream fileOut = new FileOutputStream(fileName);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(pnlCentro);
    out.close();
}