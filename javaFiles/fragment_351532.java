for (int i = 0; i < timeInterval; i++) {
    List<IceCream> copy = new ArrayList<>(dailyIceCreamStock); // create a copy
    for(IceCream iceCream: copy){ // modify the elements of the copy
        iceCream.setSoldCount(rand.nextInt(IceCream.AMOUNT + 1));
        iceCream.setStockDate(date);
    }

    //Every day should have different ArrayList of values
    this.weeklyStats.put(date.toString(fmt), copy); // put the copy in the Map
    date = date.plusDays(1);
}