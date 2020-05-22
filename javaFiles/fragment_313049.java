TextField tf = new TextField() {
    @Override
    public void paste() {
        super.paste();
        System.out.println("text pasted in");
    }
}