try {
    this.tasDistibution.push(new Carte(i,j));
}
catch(CarteException CE) {
    System.err.println("Erreur : " + CE);
}