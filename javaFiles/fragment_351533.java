for (int i = 0; i < timeInterval; i++) {
    List<IceCream> copy = new ArrayList<>();
    for(IceCream iceCream: dailyIceCreamStock){ 
        IceCream newIC = new IceCream(); // not sure if you want to copy any
                                         // data from the original IceCream
        newIC.setSoldCount(rand.nextInt(IceCream.AMOUNT + 1));
        newIC.setStockDate(date);
        copy.add(newIC); // add a new IceCream instance to the new List
    }

    //Every day should have different ArrayList of values
    this.weeklyStats.put(date.toString(fmt), copy); 
    date = date.plusDays(1);
}