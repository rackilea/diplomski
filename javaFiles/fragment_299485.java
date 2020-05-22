sheet.addListener(new TabSheet.SelectedTabChangeListener() {
        @Override
        public void selectedTabChange(SelectedTabChangeEvent event) {
            if (event.getTabSheet().getSelectedTab() == currentComponent) {
                //here goes the code
            }
        }
});