if (Test1.isEnabled()) {
    test1.setEnabled(false);
    errorLabel.setText("");
    service.submit(()->{
        Result result = JUnitCore.runClasses(Test1.class);
        EventQueue.invokeLater(()->{
            errorMessageDisplay(result);
            test1.setEnabled(true);
        });
    });
}