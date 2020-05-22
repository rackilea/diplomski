public void balansOpladen (double bedrag) {
    if (bedrag + balans <= 5) { 
        System.out.println("U moet minstens 5 euro opladen.");
    } else if (bedrag + balans >=125) {
        System.out.println("U mag maximaal 125 euro opladen!");
    } else {
        balans += bedrag;
    }
}