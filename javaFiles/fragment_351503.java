enum DataSourceEnum {
    ds1  (["DS1 idX",  "DS1 idY",  "DS1 idZ"],  { is -> new DataSource1(is) }),
    ds2  (["DS2 idX",  "DS2 idY",  "DS2 idZ"],  { is -> new DataSource2(is) }),

    // ...

    ds20 (["DS20 idX", "DS20 idY", "DS20 idZ"], { is -> new DataSource20(is) })  

    private final static Map<String, DataSourceEnum> dsMapping = [:]

    final Closure<DataSource> buildDataSource

    private DataSourceEnum(List<String> identifiers, Closure<DataSource> ctor) {
        DataSourceEnum.dsMapping += identifiers.collectEntries { id -> [(id):this] }
        this.buildDataSource = ctor
    }

    static DataSourceEnum identify(String id) { dsMapping[id] }
}