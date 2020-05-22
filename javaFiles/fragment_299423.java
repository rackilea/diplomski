stage.maximizedProperty().addListener(new ChangeListener<Boolean>() {

    @Override
    public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
        System.out.println("maximized:" + t1.booleanValue());
    }
});