private class MyChangeListener implements ChangeListener<Number>{
    final ChoiceBox<Number> cb;

    MyChangeListener(ChoiceBox<Number> cb) {
        this.cb = cb;
     }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        System.out.println("cb: "+cb.getId());
    }

}