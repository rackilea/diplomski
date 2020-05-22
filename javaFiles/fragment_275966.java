public List getListeAnnees() {
    listeAnnees = getAnneeMetier().getAllAnnees();
    return listeAnnees;
}

public AnneeMetier getAnneeMetier() {
    if (anneeMetier == null) {
        anneeMetier = new AnneeMetierImpl();
    }
    return anneeMetier;
}