public class CustomIsolationLevelDataSourceAdapter extends IsolationLevelDataSourceAdapter {

    private final Integer customIsolationLevel;

    public CustomIsolationLevelDataSourceAdapter(Integer customIsolationLevel) {
        this.customIsolationLevel = customIsolationLevel;
    }

    @Override
    protected Integer getIsolationLevel() {
        return customIsolationLevel != null ? customIsolationLevel : super.getIsolationLevel();
    }
}