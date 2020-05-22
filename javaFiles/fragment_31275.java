public static final Unit<Energy> KILOCALORIE = SI.JOULE.times(4184);

public interface FoodEnergy extends Quantity {

    public final static Unit<FoodEnergy> UNIT
        = (Unit<FoodEnergy>) SI.GRAM.times(KILOCALORIE);
}

private static final Unit<FoodEnergy> PROTEIN_ENERGY = FoodEnergy.UNIT.times(4);
private static final Unit<FoodEnergy> ETHANOL_ENERGY = FoodEnergy.UNIT.times(7);
…