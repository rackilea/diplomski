public static double beerBrand(int theNumBeers) {   
    double total = 0;

    for (int count = 0; count < theNumBeers; count++) {    
        String beerTypeStr = JOptionPane.showInputDialog(...);
        double beerType = Double.parseDouble(beerTypeStr);
        total += beerPrice(beerType);
    }

    return total;
}