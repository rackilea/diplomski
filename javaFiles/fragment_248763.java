// Do stuffs with your list of people here
int werknemer = 0;
int werknemerMetPartner = 0;
int gast = 0;
int aantalBroodjes = 0;
for (Inschrijving inschrijving : inschrijven) {
  char categorie = inschrijving.getCategorie();
  switch (categorie) {
    case 'w':
      werknemer++;
      break;
    case 'p':
      werknemerMetPartner++;
      break;
    case 'g':
      gast++;
      break;
  }
  aantalBroodjes += inschrijving.getAantalBroodjes();
}
System.out.printf(
        "Er komen %d werknemer(s) zonder partner, %d werknemer(s) met partner en %d gast(en) naar de receptie. Er dienen %d broodjes besteld te worden.",
        werknemer, werknemerMetPartner, gast, aantalBroodjes);