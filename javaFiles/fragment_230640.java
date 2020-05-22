if (Test1.isEnabled()) {
    errorLabel.setText("");
    service.submit(()->{
        Result result = JUnitCore.runClasses(Test1.class);
        EventQueue.invokeLater(()->errorMessageDisplay(result));
    });
}