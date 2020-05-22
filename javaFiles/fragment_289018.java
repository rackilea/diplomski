new AjaxFallbackDefaultDataTable<MyCustomObject>(
    id, columns, dataProvider, rowsPerPage){

    @Override
    protected Item<MyCustomObject> newRowItem(String id,
        int index,
        final IModel<MyCustomObject> model){
        Item<MyCustomObject> item = super.newRowItem(id, index, model);
        item.add(new AbstractBehavior(){

            private static final long serialVersionUID = 1L;

            /**
             * {@inheritDoc}
             */
            @Override
            public void onRendered(Component component){
                if(model.getObject().isEpicFail()){
                    component.getResponse().write(
                    "<tr><td colspan=\"3\">This is an epic fail</td></tr>");
                }
            }

        });
        return item;
    }

    private static final long serialVersionUID = 1L;

}