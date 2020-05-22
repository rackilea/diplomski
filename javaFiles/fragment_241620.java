while (count <= theNumBeers) {    
    beerTypeStr = JOptionPane.showInputDialog(...);
    beerType = Double.parseDouble(beerTypeStr);
    beeer = beerPrice(beerType);
    total += beeer;

    count++;
}