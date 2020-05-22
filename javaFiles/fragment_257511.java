class UITextRectangle {

    public void doTick() {
        // template method, is empty
    }
}
...
UITextRectangle tr = new UITextRectangle(...) {

    @Override
    public void doTick() {
        this.setText(...);
    }
};