public void reloadList(DataPassRegister dataPassRegister) {

    this.form.remove("selectGroup");
    final RadioGroup selectGroup = new RadioGroup("selectGroup");

    selectGroup.setOutputMarkupId(true);
    selectGroup.setOutputMarkupPlaceholderTag(true);
    add(selectGroup);
    this.form.add(selectGroup);

    final ListView selectRepetor = new ListView("selectRepetor", dataPassRegister.getNameList())
        {
        @Override
        protected void populateItem(final ListItem item)
        {
            final Radio radio = new Radio("selection", new Model(item.getModelObject().toString()));
            final Label label = new Label("name", new Model(item.getModelObject().toString()));
            radio.setOutputMarkupId(true);
            radio.setOutputMarkupPlaceholderTag(true);
            item.add(radio);
            item.add(label);
            item.setOutputMarkupId(true);
            radio.add(new AjaxEventBehavior("onclick")
            {
                @Override
                protected void onEvent(AjaxRequestTarget target)
                {
                }
            });
        }
    };
    selectRepetor.setOutputMarkupId(true);
    selectRepetor.setOutputMarkupPlaceholderTag(true);
    selectGroup.add(selectRepetor);
}