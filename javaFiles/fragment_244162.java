table.addGeneratedColumn(CHECKBOX_COLUMN, new Table.ColumnGenerator() {
        @Override
        public Object generateCell(final Table source, final Object itemId, Object columnId) {

            final CheckBox checkBox = new CheckBox();
            checkBox.addValueChangeListener(new ValueChangeListener() {

                @Override
                public void valueChange(ValueChangeEvent event) {

                    /*
                     * do something with the itemId
                     */

                    //cast to Person entity if your table itemId is an entity object
                    Person person = (Person) itemId;
                    person.setActive(checkBox.getValue());
                }
            });

            return checkbox;
        }
    });