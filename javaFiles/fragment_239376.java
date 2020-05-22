private boolean sendMessage(UserInfo userInfo) {
    URL url = Builder.formKey("my-form-key-from-url")
            .put(MyForm.USER_NAME, userInfo.getName())
            .put(MyForm.MESSAGE, "hello")
            .toUrl();
    Submitter submitter = new Submitter(
        new Configuration()
    );
    try {
       submitter.submitForm(url);
    } catch (NotSubmittedException ex) {
        // TODO: log & handle the exception properly
        return false;
    }
    return true;
}