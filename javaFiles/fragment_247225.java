private transient DataModel<ObWithDate> model;

private DataModel<ObWithDate> getModel() {
    if (model == null) {
        model = new ListDataModel<ObWithDate>(list);
    }
    return model;
}