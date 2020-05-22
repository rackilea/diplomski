if (Test1.isEnabled()) {
    errorLabel.setText("");
    new Thread(()->{
        Result result = JUnitCore.runClasses(Test1.class);
        EventQueue.invokeLater(()->errorMessageDisplay(result));
    }).start();
}