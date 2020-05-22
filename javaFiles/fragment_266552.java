class FuelData { 
    String KEY_TYPE;
    double highest;
    double average;
    double lowest;
    // if future support for currency types needed, would go here, hook in to units attribute in xml
    FuelData(String type) { // call this every time a type is encountered parsing html
        KEY_TYPE = type;
    }

    void setHighest(String val) { // here, val is value of "Highest" element
        try {
            highest = Double.parseDouble(val); // because you're not using a Scanner to parse
        } catch (NumberFormatException e) {
        // handle appropriately
        }
        // perhaps sanity check: disallow negatives, check not less than lowest, etc.
    }

    // and so on for average and lowest

    double computeSavings(FuelData pricesB) { // called by onClick
    // your subtraction goes here. Perhaps you decide it's reasonable to use this method
    // to compute savings for Regular vs. Premium and therefore do not check type,
    // perhaps you decide that's illogical and do check types.
    // Note: good arguments can be made that this method should exist in a different
    // class. I've placed it here for simplicity's sake.
    }
}