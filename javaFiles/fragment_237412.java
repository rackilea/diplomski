try (Scanner reader = new Scanner(System.in)) {

    int x = 1;

    while (x > 0) {

        System.out.println("entre nombre de seconde: ");
        x = reader.nextInt(); // Scans the next token of the input as an int.
        int min = x / 60; //division entière
        x = x % 60; //nombre de seconde restante
        int heure = min / 60; //division entière
        min = min % 60; //nombre de minutes restante
        int jour = heure / 24; //division entière
        heure = heure % 24; //nombre d'heures restante
        System.out.println(jour + ":" + heure + ":" + min + ":" + x);

    }

}