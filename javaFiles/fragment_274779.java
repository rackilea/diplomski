public static void laatBotenMetMinimumAantalMastenZien(ArrayList<Boot> boten, int minimumAantalMasten) {
    System.out.println("\n=== Boten met minimum aantal aan masten ===");
    for (Boot boot : boten) {
        if (minimumAantalMasten > boot.getAantalMasten()) {
            System.out.println(boot.toString());
        }
    }
}