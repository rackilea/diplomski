ObservableList<BeanExample2> names = FXCollections.observableArrayList(new Callback<BeanExample2, Observable[]>() {
    @Override
    public Observable[] call(BeanExample2 param) {
        return new Observable[]{param.nameProperty()};
    }
});