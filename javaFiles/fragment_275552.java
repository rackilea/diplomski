IModel<List<E>> listModel = new LoadableDetachableModel<List<E>>() {

    public List<E> load() {
        return Arrays.asList(a1Model.getObject(), a2Model.getObject());
    }

}