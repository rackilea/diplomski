public static double calculateCost(int ShirtsOrdered) {
    if (ShirtsOrdered > 10){
        return 200.0 + (ShirtsOrdered - 10) * 15.0;
    }
     return ShirtsOrdered * 20.0;
}