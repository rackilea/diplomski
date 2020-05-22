class FormSubmitterFactory {
    public static FormSubmitter getSubmitter() {
        if (connectionAvailable()) {
            return new ServerFormSubmitter();
        } else {
            return new LocalFormSubmitter();
        }
    }
}