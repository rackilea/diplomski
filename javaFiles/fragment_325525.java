public static int CalculateCost() {
        String typeOfCarCost = askCarType();
        String SolarPanelCost = askSolarPanel();
        final int basicPrice = 20000;
        final int ElectricModel = 2000;
        final int SolarPanel = 5000;
        final int Discount = calculateDiscount(typeOfCarCost, SolarPanelCost);/////here you send the input fromthe user to this method without needing to call it again
        int total = 0;
        ....
  }