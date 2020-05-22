public boolean validateInput() {
    boolean validated = true;
    for (ValidatableField field : mUserValues.getValidatableFields()) {
        if (!field.isValid()) {
            field.showError(R.string.error);
            validated = false;
        }
    }
    return validated;
}