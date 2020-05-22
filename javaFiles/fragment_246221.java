Warenkorb(String kunde, Object[] artikel){
    this.kunde = kunde;
    this.artikelliste = artikel;
    this.sessionid = s.nextInt();
    double summe = 0;
    for (Object preis : artikel) {
         summe += ((Artikel)preis).getVerkaufspreis();
    }
}