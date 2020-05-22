@PostConstruct
public void init(){
    initTable();
}

private void initTable(){
    lazyModel = new LazyRequestActivitiesDataModel(deptList,deptService);
}

public LazyDataModel<Department> getLazyModel() {
    return lazyModel;