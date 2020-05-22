private List<Nutzer> nutzerList;

public List<Nutzer> getNutzerList() {
    nutzerList = nutzerManager.getNutzer();
    return this.nutzerList;
}