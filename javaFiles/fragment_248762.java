List<Inschrijving> inschrijven = new ArrayList<>();
try (Scanner invoer = new Scanner(System.in)) { // http://tutorials.jenkov.com/java-exception-handling/try-with-resources.html
  System.out.println("Zijn er nog inschrijvingen? ");
  String antwoord = invoer.nextLine();
  char eersteLetter = antwoord.toLowerCase().charAt(0);
  while (eersteLetter != 'n') {

    Inschrijving inschrijving = null;
    System.out.println("Wie mag ik inschrijven? ");
    String naam = invoer.nextLine();
    char categorieEersteLetter = 0;
    do {
      System.out.printf(
          "Tot welke categorie behoort u?\nTyp w voor een werknemer, p voor een werknemer met partner, g voor een gast: ");
      String categorie = invoer.nextLine();
      categorieEersteLetter = categorie.toLowerCase().charAt(0);
    } while (categorieEersteLetter != 'w' && categorieEersteLetter != 'p' && categorieEersteLetter != 'g');
    inschrijving = new Inschrijving(naam, categorieEersteLetter);

    int maxBroodjes = (inschrijving.geefAantalPersonen() * 5);
    int tijdelijk;
    do {
      System.out.printf("Hoeveel broodjes wil je bestellen? (max %d) ", maxBroodjes);
      tijdelijk = invoer.nextInt();
      invoer.nextLine(); // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo 
    } while (tijdelijk > maxBroodjes);
    inschrijving.setAantalBroodjes(tijdelijk);
    inschrijven.add(inschrijving);

    System.out.println("Zijn er nog inschrijvingen? ");
    antwoord = invoer.nextLine();
    eersteLetter = antwoord.toLowerCase().charAt(0);
  }
}