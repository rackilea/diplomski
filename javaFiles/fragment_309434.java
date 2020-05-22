boolean ageRestrProcessor(int keyNum, String itemNameFromDB, double itemUnitPriceFromDB, boolean ageValidationStatus, boolean ageValidator, String itemUnit, Map<Integer, Object[]> map){
         //..code
         // you can remove  boolean ageValidationStatus from method signature
    if (ageValidator){
         //..code
         return false;
    }
    else {
        System.out.println("\tShopper is underage. Item not added");
        return true;
    }
  }