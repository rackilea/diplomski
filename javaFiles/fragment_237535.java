Map<String, Integer> cityPrices = HashMap<String, Integer>();
 Map<String, Integer> seasonPrices = HashMap<String, Integer>();
 Map<String, Integer> mealPrices = HashMap<String, Integer>();

 // Don't forget to initialize your collections. 
 // Put possible string values and their prices in maps.

 cityPrices.put("Tokyo", 10000);
 ...

 Integer regionPrice = cityPrices.get(RegionBx.getSelectedItem()); 
 Integer seasonPrice = regionPrice * seasonPrices.get(SeasonBx.getSelectedItem());
 Integer mealPrice = regionPrice * mealPrices.get(MealBx.getSelectedItem());

 Integer travelCost = regionPrice + seasonPrice + mealPrice; // Now it is one line for all cases.