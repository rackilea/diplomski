public void itemStateChanged(final ItemEvent event) {
    if (event.getStateChange() == event.DESELECTED) {
        deselectedFoo = (Foo) event.getItem();
    } 
    else if (event.getStateChange() == event.SELECTED) {
        FooChangedHandler(deselectedFoo,(Foo) event.getItem());
    }
}