class ServerFormSubmitter implements FormSubmitter {
    @Override
    public void submitForm(FormData data) {
        // submit to the server
    }
}

class LocalFormSubmitter implements FormSubmitter {
    @Override
    public void submitForm(FormData data) {
        // save to DB
    }
}