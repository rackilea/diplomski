public class RestApiResponse {

    @JSON(name="Target Collection")
    private List<TargetWrapper> targetCollection = new ArrayList<TargetWrapper>();

    @JSON(name="Target Collection")
    public List<TargetWrapper> getTarget_Collection() {
        return targetCollection;
    }
    @JSON(name="Target Collection")
    public void setTarget_Collection(List<TargetWrapper> tc) {
        this.targetCollection = tc;
    }

}