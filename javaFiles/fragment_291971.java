this.ddt.get().getRowsProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        System.out.println("bip!");
        rif.set(...... buildString ......);
    }
});