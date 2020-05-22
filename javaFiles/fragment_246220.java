Warenkorb(String kunde, Artikel[] artikel){
    this.kunde = kunde;
    this.artikelliste = artikel;
    this.sessionid = s.nextInt();
    double summe = 0;
    for (Artikel preis : artikel) {
         summe += preis.getVerkaufspreis();
    }
}