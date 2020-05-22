public enum ItemType
{
    FRUITS("fru"),
    VEGETABLES("veg"),
    LIQUOURS("liq"),
    SODAS("sod");

    public static final EnumSet<ItemType> LIQUIDS = EnumSet.of(LIQUOURS, SODAS);

    // ...
}