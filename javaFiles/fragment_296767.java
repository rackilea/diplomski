ColorChooserButton colorChooser = new ColorChooserButton(Color.WHITE);
colorChooser.addColorChangedListener(new ColorChangedListener() {
    @Override
    public void colorChanged(Color newColor) {
            // do something with newColor ...
    }
});