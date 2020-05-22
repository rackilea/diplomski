public class TypedObservableList<P extends PlanItem> {
    private final Class<P> type ;
    private final ObservableList<P> list ;

    public TypedObservableList(Class<P> type) {
        this.type = type ;
        this.list = FXCollections.observableArrayList();
    }

    public Class<P> getType() {
        return type ;
    }

    public ObservableList<P> getList() {
        return list ;
    }
}