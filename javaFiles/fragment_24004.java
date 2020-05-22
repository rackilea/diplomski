clientComp.setChangeListener(new NavigationClientCompositeListener() {

    @Override
    public void notifyChange() {
        B.this.notifyChange(); //Calls the notifyChange() of B, which is the outer class
    }
});