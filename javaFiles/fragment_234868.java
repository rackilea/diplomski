@Override
    protected ResultItem<?> load() {
        return resultListModel.getObject().get(index).getObject();
    }

    @Override
    public void detach() {
        resultListModel.setObject(results);
    }