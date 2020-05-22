private void showLanguagePicker() {
    InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
    if (imeManager != null) {
        imeManager.showInputMethodPicker();
    } else {

    }
}