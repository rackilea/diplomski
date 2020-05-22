class Info {
    private String niveau;
    private String naam;
    private int lln;
    private String klas;

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLln() {
        return lln;
    }

    public void setLln(int lln) {
        this.lln = lln;
    }

    public String getKlas() {
        return klas;
    }

    public void setKlas(String klas) {
        this.klas = klas;
    }

    @Override
    public String toString() {
        return "Info [niveau=" + niveau + ", naam=" + naam + ", lln=" + lln
                + ", klas=" + klas + "]";
    }
}