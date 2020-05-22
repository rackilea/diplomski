public static int calculateDiscount(String typeOfCarSelected, String SolarPanelSelected) {
        int Discount = 0;
        if ((typeOfCarSelected.equals("Electric") || typeOfCarSelected.equals("electric")) && ((SolarPanelSelected.equals("Yes") || SolarPanelSelected.equals("yes")))) {
            Discount = 500;
        } else {
            Discount = 0;
        }
        return Discount;
    }//ends calculateDiscount