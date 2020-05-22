checkForm.add(new SubmitLink("submit") {
    @Override
    public void onSubmit() {
        super.onSubmit();
        // ...new captcha here...
    }
}.setDefaultFormProcessing(false));