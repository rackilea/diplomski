combofieldeditor.setPropertyChangeListener(new IPropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            System.out.print(event.getNewValue());
        }
    });