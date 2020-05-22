public class MockAssetRepository extends AssetRepository {
    private List<Invocation> invocations = new ArrayList<>();

    @Override
    public void attachAssets(Animal a) {
        // store the invocation to be able to chack if it has been called, 
        // how many times, etc.
        invocations.add(new Invocation("attachAssets", a);
    }
}