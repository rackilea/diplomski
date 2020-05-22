abstract class Item {
    public final int sku
    // ....
}

class PinkCurtains extends Item {
    public PinkCurtains() {
        sku = 129534;
        desc = "Adorable Pink Indoor Curtains";
    }
}

class FuzzyTowel extends Item {
    public FuzzyTowel() {
        sku = 874164;
        desc = "Machine Washable Fuzzy Towel";
    }
}