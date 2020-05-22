@Override 
public ObservableValue<T> call(CellDataFeatures<S,T> param) {
    return getCellDataReflectively(param.getValue());
}

private ObservableValue<T> getCellDataReflectively(S rowData) {
    ...

     if (propertyRef.hasProperty()) {
         return propertyRef.getProperty(rowData);
     } else {
         T value = propertyRef.get(rowData);
         return new ReadOnlyObjectWrapper<T>(value);
     }
     ...   
}