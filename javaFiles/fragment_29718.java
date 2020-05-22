private Field<?> getNoEditableField(final String columnName) {
    CustomField<Label> result = new CustomField() {
        @Override
        protected Component getContent() {
            Label result = (Label) super.getContent();
            Object editedItemId = getEditedItemId();
            String value = DEFAULT_VALUE;
            if (editedItemId != null) {
                value = CustomizableGrid.this.toString(getContainerDataSource().getItem(editedItemId).getItemProperty(columnName).getValue());
            }
            result.setValue(value);
            return result;
        }

        @Override
        protected Component initContent() {
            Label result = new Label(DEFAULT_VALUE, ContentMode.HTML);
            result.setDescription(getColumnDescription(columnName));
            result.setStyleName("immutablegridcellstyle");
            return result;
        }

        @Override
        public Class getType() {
            return Label.class;
        }
    };
    result.setConverter(new Converter<Label, Object>() {
    //converter for your data
    });

    return result;
}