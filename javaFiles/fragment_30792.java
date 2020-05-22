public static void main(String[] args) {
    int keuze = 1;
    BigDecimal bedrag;
    BigDecimal factord = BigDecimal.valueOf(1.1);
    BigDecimal factorp = BigDecimal.valueOf(0.87);
    BigDecimal factorl = BigDecimal.valueOf(5.38);
    Scanner c = new Scanner(System.in);
    System.out.print("Kies uw valuta: \n 1    -    AmerikaanseDollar\n 2 - Engelse Pond\n 3 - Turkse Lira\n");
    if(keuze == 1) {
        keuze = c.nextInt();
        System.out.print("Voer het gewenste bedrag in euro's: ");

        bedrag = BigDecimal.valueOf(c.nextDouble());
        System.out.println(bedrag.multiply(factord) + " Dollar");
    }
}