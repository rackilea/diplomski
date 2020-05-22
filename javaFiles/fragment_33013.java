public Button createMyButton(double X, double Y, String label, String image_path) throws Exception {
    Button button = new Button(...) // not sure how you're initialising your buttons normally
    button.setTranslateX(X);
    button.setTranslateY(Y);
    button.setText(label);
    button.setButtonImage(src=image_path);
    return button
}