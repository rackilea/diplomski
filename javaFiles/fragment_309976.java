class ItemVisitor { 
    public void accept(Item item) {
        // Do something
        for (Item i : item.getChildren()) {
            this.accept(i);
        }
    }
}