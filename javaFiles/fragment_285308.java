textField.setSkin(new TextFieldSkin(textField){
    @Override
    protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        return 1 + super.computePrefWidth(height, topInset, rightInset, bottomInset, leftInset);
    }
});