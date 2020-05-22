// fill this list appropriately
final List<AppConfigTO> dummyList = Arrays.asList(...);

AppConfigManager appManager = new AppConfigManager() {
    @Override
    public List<AppConfigTO> getAppConfig() {
        return dummyList;
    }
};