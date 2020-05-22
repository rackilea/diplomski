public enum CatanPiece implements Buildable
{
    ROAD, SETTLEMENT, CITY;

    private static final Map<CatanPiece, Map<Resource, Integer>> allCosts =
            buildCostMap();

    private static Map<CatanPiece, Map<Resource, Integer>> buildCostMap()
    {
        Map<CatanPiece, Map<Resource, Integer>> result =
            new HashMap<CatanPiece, Map<Resource, Integer>>();

        Map<Resource, Integer> cost = new EnumMap<Resource, Integer>(Resource.class);
        cost.put(Resource.WHEAT, 2);
        cost.put(Resource.ORE, 3);
        result.put(CITY, Collections.unmodifiableMap(cost));

        cost = new EnumMap<Resource, Integer>(Resource.class);
        cost.put(Resource.BRICK, 1);
        cost.put(Resource.LUMBER, 1);
        cost.put(Resource.SHEEP, 1);
        cost.put(Resource.WHEAT, 1);
        result.put(SETTLEMENT, Collections.unmodifiableMap(cost));

        cost = new EnumMap<Resource, Integer>(Resource.class);
        cost.put(Resource.BRICK, 1);
        cost.put(Resource.LUMBER, 1);
        result.put(ROAD, Collections.unmodifiableMap(cost));

        return Collections.unmodifiableMap(result);
    }

    @Override
    public Map<Resource, Integer> getCost() {
        return allCosts.get(this);
    }

    @Override
    public Buildable build(final PlayerHand payment) {
        return payment.remove(cost) ? null : this;
    }
}