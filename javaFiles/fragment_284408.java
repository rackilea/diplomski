mainWindow.addComponent(new Label(new Property() {
        public Object getValue() {
            return "Wellcome to Vaadin!";
        }

        public void setValue(Object newValue) throws ReadOnlyException, ConversionException {
            throw new ReadOnlyException();
        }

        public Class<?> getType() {
            return String.class;
        }

        public boolean isReadOnly() {
            return true;
        }

        public void setReadOnly(boolean newStatus) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String toString() {
            return (String) getValue();
        }
    }));