subCategoryList.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
           String selectedValue = subCategoryList.getSelectedValue();
           // do stuff with selectedValue...
        }
    }
});